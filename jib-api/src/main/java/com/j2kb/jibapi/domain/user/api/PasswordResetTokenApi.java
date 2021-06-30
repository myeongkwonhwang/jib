package com.j2kb.jibapi.domain.user.api;

import com.j2kb.jibapi.domain.user.entity.PasswordResetToken;
import com.j2kb.jibapi.domain.user.service.MailSendService;
import com.j2kb.jibapi.domain.user.service.PasswordResetService;
import com.j2kb.jibapi.global.common.SuccessResponse;
import com.j2kb.jibapi.global.error.exception.ErrorCode;
import com.j2kb.jibapi.global.error.exception.InvalidValueException;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/password-reset-token")
public class PasswordResetTokenApi {

    private final MailSendService mailSendService;
    private final PasswordResetService passwordResetService;

    @GetMapping
    @ApiOperation(value = "비밀번호 초기화 토큰 생성/저장 및 토큰 메일 전송 (토큰 조회)")
    public SuccessResponse generatePasswordResetToken(String email) {
        mailSendService.sendAuthMail(email);
        return SuccessResponse.success();
    }



    @PostMapping
    @ApiOperation(value = "비밀번호 토큰 validate 및 토큰 삭제")
    public SuccessResponse confirmPasswordResetToken(String email, String authKey) {
        PasswordResetToken token = passwordResetService.read(email);
        if (!authKey.equals(token.getToken())) {
            throw new InvalidValueException("token is not valid", ErrorCode.INVALID_INPUT_VALUE);
        }
        passwordResetService.remove(token);
        return SuccessResponse.success();
    }
}
