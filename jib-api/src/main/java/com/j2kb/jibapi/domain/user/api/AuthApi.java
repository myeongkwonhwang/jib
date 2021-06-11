package com.j2kb.jibapi.domain.user.api;

import com.j2kb.jibapi.global.config.security.jwt.TokenProvider;
import com.j2kb.jibapi.domain.user.dto.LoginDto;
import com.j2kb.jibapi.domain.user.dto.TokenDto;
import com.j2kb.jibapi.domain.user.service.UserLoginService;
import com.j2kb.jibapi.global.common.SuccessResponse;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
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
        response.setHeader(TokenProvider.AUTHORIZATION_HEADER, "Bearer " + jwt);

        return SuccessResponse.success(new TokenDto(jwt));

    }
}
