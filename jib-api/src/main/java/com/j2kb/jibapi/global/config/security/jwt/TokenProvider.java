package com.j2kb.jibapi.global.config.security.jwt;

import com.j2kb.jibapi.domain.user.entity.User;
import com.j2kb.jibapi.global.config.security.AuthenticationFacade;
import com.j2kb.jibapi.global.config.security.UserPrincipal;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

// jwt.secret, jwt.token-validity-in-seconds 값을 주입받는다.
@Component
@Slf4j
public class TokenProvider implements InitializingBean {

    private static final String AUTHORITIES_KEY = "type";
    public static final String AUTHORIZATION_HEADER = "Authorization";

    private final String secret;
    private final long tokenValidityInMilliseconds;
    private Key key;
    private final AuthenticationFacade authenticationFacade;

    public TokenProvider(
        @Value("${jwt.secret}") String secret,
        @Value("${jwt.token-validity-in-seconds}") long tokenValidityInSeconds, AuthenticationFacade authenticationFacade) {
        this.secret = secret;
        this.tokenValidityInMilliseconds = tokenValidityInSeconds * 1000;
        this.authenticationFacade = authenticationFacade;
    }

    //빈이 생성되고 의존성 주입까지 끝낸 후
    //주입받은 secret 값을 base64 decode 하여 key 변수에 할당한다.
    @Override
    public void afterPropertiesSet() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    // Authentication 객체에 포함되어 있는 권한 정보를 담은 토큰을 생성한다.
    // jwt.token-validity-in-seconds 값을 이용해 토큰 만료 시간을 지정한다.
    public String createToken(User user) {

        long now = (new Date()).getTime();
        Date validity = new Date(now + this.tokenValidityInMilliseconds);

        return Jwts.builder()
            .setSubject(user.getEmail())
            .setClaims(user.toClaims())
            .signWith(key, SignatureAlgorithm.HS512)
            .setExpiration(validity)
            .compact();
    }

    // 토큰에 담겨 있는 권한 정보를 이용해 Authentication 객체를 리턴한다.
    public Authentication getAuthentication(String token) {
        Claims claims = Jwts
            .parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .getBody();

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + claims.get(AUTHORITIES_KEY).toString()));

        User user = User.valueOf(claims);
        
        user.setPassword(user.getPassword());
        UserPrincipal principal = UserPrincipal.create(user);

        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }

    // 토큰을 검증하는 역할을 수행한다.
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            log.info("malformed JWT signature.");
        } catch (ExpiredJwtException e) {
            log.info("expired JWT");
        } catch (UnsupportedJwtException e) {
            log.info("not supported JWT");
        } catch (IllegalArgumentException e) {
            log.info("illegal JWT.");
        }
        return false;
    }

    public String genarateToken() {
        UserPrincipal userPrincipal = authenticationFacade.getUserPrincipal();
        long now = (new Date()).getTime();
        Date validity = new Date(now + this.tokenValidityInMilliseconds);

        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .setClaims(userPrincipal.toClaims())
                .signWith(key, SignatureAlgorithm.HS512)
                .setIssuedAt(new Date())
                .setExpiration(validity)
                .compact();
    }

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return bearerToken;
    }
}