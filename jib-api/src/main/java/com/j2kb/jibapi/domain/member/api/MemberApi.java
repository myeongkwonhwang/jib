package com.j2kb.jibapi.domain.member.api;

import com.j2kb.jibapi.domain.member.dto.MemberJoinDto;
import com.j2kb.jibapi.domain.member.service.MemberJoinService;
import com.j2kb.jibapi.global.common.SuccessResponse;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by mkhwang on 2021/04/29
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@RestController
@RequestMapping("/api/v1/member")
@Slf4j
@RequiredArgsConstructor
public class MemberApi {

    private final MemberJoinService memberJoinService;

    @PostMapping
    @ApiOperation(value = "기본회원가입")
    public SuccessResponse save(@Valid @RequestBody MemberJoinDto.BasicReq basicReq) {
        MemberJoinDto.BasicRes basicRes = memberJoinService.save(basicReq);
        return SuccessResponse.success(basicRes);
    }
}
