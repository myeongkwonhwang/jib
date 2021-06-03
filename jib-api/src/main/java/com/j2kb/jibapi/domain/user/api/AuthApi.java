package com.j2kb.jibapi.domain.user.api;

import com.j2kb.jibapi.domain.jwt.JwtFilter;
import com.j2kb.jibapi.domain.jwt.TokenProvider;
import com.j2kb.jibapi.domain.user.dto.LoginDto;
import com.j2kb.jibapi.domain.user.dto.TokenDto;
import com.j2kb.jibapi.domain.user.entity.User;
import com.j2kb.jibapi.global.common.SuccessResponse;
import com.j2kb.jibapi.global.config.security.UserDetailService;

import com.sun.net.httpserver.Authenticator.Success;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
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
    public SuccessResponse authorize(HttpServletResponse response, @Valid @RequestBody LoginDto.Req req) {

        final User user = userDetailService.findByEmailAndPassword(req);

        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword()));

        String jwt = tokenProvider.createToken(user);
        response.setHeader(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        return SuccessResponse.success(new TokenDto(jwt));

    }

    @GetMapping("/mailConfirm")
    public SuccessResponse mailConfirm(String email, String authKey) {
        
    }

}
