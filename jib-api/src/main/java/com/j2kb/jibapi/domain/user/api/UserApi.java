package com.j2kb.jibapi.domain.user.api;

import com.j2kb.jibapi.domain.user.dto.UserJoinDto;
import com.j2kb.jibapi.domain.user.service.UserJoinService;
import com.j2kb.jibapi.global.common.SuccessResponse;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by mkhwang on 2021/04/29
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@RestController
@RequestMapping("/api/v1/user")
@Slf4j
@RequiredArgsConstructor
public class UserApi {

    private final UserJoinService userJoinService;

    @PostMapping
    @ApiOperation(value = "기본회원가입")
    public SuccessResponse save(@Valid @RequestBody UserJoinDto.BasicReq basicReq) {
        UserJoinDto.BasicRes basicRes = userJoinService.save(basicReq);
        return SuccessResponse.success(basicRes);
    }
}
