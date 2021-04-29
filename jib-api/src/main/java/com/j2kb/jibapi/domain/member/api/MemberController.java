package com.j2kb.jibapi.domain.member.api;

import com.j2kb.jibapi.domain.member.dto.request.MemberJoinReq;
import com.j2kb.jibapi.domain.member.dto.response.MemberJoinRes;
import com.j2kb.jibapi.domain.member.service.MemberJoinService;
import com.j2kb.jibapi.global.common.SuccessResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
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
@RequestMapping("/v1/member")
@Slf4j
@AllArgsConstructor
public class MemberController {

    private MemberJoinService memberJoinService;

    @PostMapping
    public SuccessResponse saveMember(@Valid @RequestBody MemberJoinReq memberJoinReq) {
        MemberJoinRes response = memberJoinService.saveMember(memberJoinReq);
        return SuccessResponse.success(response);
    }

}
