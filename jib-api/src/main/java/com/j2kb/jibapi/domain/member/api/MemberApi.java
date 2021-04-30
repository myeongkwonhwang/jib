package com.j2kb.jibapi.domain.member.api;

import com.j2kb.jibapi.domain.member.dto.MemberJoinDto;
import com.j2kb.jibapi.domain.member.service.MemberJoinService;
import com.j2kb.jibapi.global.common.SuccessResponse;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class MemberApi {

    private MemberJoinService memberJoinService;

    @PostMapping
    public SuccessResponse save(@Valid @RequestBody MemberJoinDto.BasicJoinReq req) {
        MemberJoinDto.BasicJoinRes response = memberJoinService.save(req);
        return SuccessResponse.success(response);
    }
}
