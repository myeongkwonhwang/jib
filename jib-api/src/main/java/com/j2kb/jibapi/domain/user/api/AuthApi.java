package com.j2kb.jibapi.domain.user.api;

import com.j2kb.jibapi.domain.jwt.JwtFilter;
import com.j2kb.jibapi.domain.jwt.TokenProvider;
import com.j2kb.jibapi.domain.user.dto.LoginDto;
import com.j2kb.jibapi.domain.user.dto.TokenDto;
import com.j2kb.jibapi.domain.user.entity.PasswordResetToken;
import com.j2kb.jibapi.domain.user.entity.User;
import com.j2kb.jibapi.domain.user.service.PasswordResetService;
import com.j2kb.jibapi.domain.user.service.MailSendService;
import com.j2kb.jibapi.domain.user.service.UserUpdateService;
import com.j2kb.jibapi.domain.user.service.UserLoginService;
import com.j2kb.jibapi.global.common.SuccessResponse;
import com.j2kb.jibapi.global.config.security.UserDetailService;

import com.j2kb.jibapi.global.error.exception.ErrorCode;
import com.j2kb.jibapi.global.error.exception.InvalidValueException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
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

    private final UserLoginService userLoginService;

    @PostMapping("/login")
    public SuccessResponse authorize(HttpServletResponse response, @Valid @RequestBody LoginDto.Req req) {
        String jwt = userLoginService.authorize(req);
        response.setHeader(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        return SuccessResponse.success(new TokenDto(jwt));

    }
}
