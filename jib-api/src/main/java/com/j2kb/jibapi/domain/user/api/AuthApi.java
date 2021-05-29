package com.j2kb.jibapi.domain.user.api;

import com.j2kb.jibapi.domain.jwt.JwtFilter;
import com.j2kb.jibapi.domain.jwt.TokenProvider;
import com.j2kb.jibapi.domain.user.dto.LoginDto;
import com.j2kb.jibapi.domain.user.dto.TokenDto;
import com.j2kb.jibapi.domain.user.entity.User;
import com.j2kb.jibapi.global.config.security.UserDetailService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthApi {

    private final TokenProvider tokenProvider;
    private final AuthenticationManager authenticationManager;
    private final UserDetailService userDetailService;

    @PostMapping("/login")
    public ResponseEntity<TokenDto> authorize(@Valid @RequestBody LoginDto.Req req) {

        String email = req.getEmail();
        String password = req.getPassword();

        final User user = userDetailService.findByEmailAndPassword(email, password);

        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(email, password));

        String jwt = tokenProvider.createToken(user);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        return new ResponseEntity<>(new TokenDto(jwt), httpHeaders, HttpStatus.OK);

    }
}
