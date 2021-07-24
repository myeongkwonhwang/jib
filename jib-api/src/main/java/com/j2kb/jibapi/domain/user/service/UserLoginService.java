package com.j2kb.jibapi.domain.user.service;

import com.j2kb.jibapi.domain.user.dao.RefreshTokenRedisRepository;
import com.j2kb.jibapi.domain.user.dto.TokenDto;
import com.j2kb.jibapi.domain.user.entity.RefreshToken;
import com.j2kb.jibapi.domain.user.enums.TokenType;
import com.j2kb.jibapi.global.common.SuccessResponse;
import com.j2kb.jibapi.global.config.security.jwt.TokenProvider;
import com.j2kb.jibapi.domain.user.dao.UserRepository;
import com.j2kb.jibapi.domain.user.dto.LoginDto;
import com.j2kb.jibapi.domain.user.entity.User;
import com.j2kb.jibapi.global.config.security.UserPrincipal;
import com.j2kb.jibapi.global.error.exception.BusinessException;
import com.j2kb.jibapi.global.error.exception.EntityNotFoundException;
import com.j2kb.jibapi.global.error.exception.ErrorCode;
import com.j2kb.jibapi.global.error.exception.InvalidTokenException;
import com.j2kb.jibapi.global.error.exception.InvalidValueException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by mkhwang on 2021/06/02
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserLoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    private final AuthenticationManager authenticationManager;
    private final RefreshTokenRedisRepository refreshTokenRedisRepository;

    public TokenDto authorize(LoginDto.Req req) {
        User user = findByEmailAndPassword(req);
        return this.authenticate(UserPrincipal.create(user), req.getPassword());
    }

    private User findByEmailAndPassword(LoginDto.Req req) {
        User user = findByEmail(req.getEmail());
        if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
            throw new BusinessException("잘못된 비밀번호입니다.",  ErrorCode.UNAUTHORIZED);
        }
        return user;
    }

    private User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(()-> new EntityNotFoundException("일치하는 회원정보가 없습니다."));
    }

    public TokenDto authenticate(UserPrincipal userPrincipal, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userPrincipal
                        , password
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        TokenDto tokenDto = tokenProvider.genarateToken();

        // save refresh token to redis
        refreshTokenRedisRepository.save(RefreshToken.builder()
                .token(tokenDto.getRefreshToken())
                .timeToLive(TokenType.REFRESH_TOKEN.getValidTime())
            .build());

        return tokenDto;
    }

    public String refreshToken(String refreshToken) {
        refreshTokenRedisRepository.findById(refreshToken)
            .orElseThrow(() -> new InvalidTokenException(TokenType.REFRESH_TOKEN));
        return tokenProvider.generateToken(tokenProvider.getUserPrincipal(refreshToken), TokenType.ACCESS_TOKEN);
    }

    public void signout(String refreshToken) {
        refreshTokenRedisRepository.delete(RefreshToken.builder().token(refreshToken).build());
    }
}