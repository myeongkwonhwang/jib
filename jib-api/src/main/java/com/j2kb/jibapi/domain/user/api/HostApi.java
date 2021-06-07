package com.j2kb.jibapi.domain.user.api;

import com.j2kb.jibapi.domain.user.dto.JoinDto;
import com.j2kb.jibapi.domain.user.service.HostJoinService;
import com.j2kb.jibapi.global.common.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by mkhwang on 2021/06/06
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@RestController
@RequestMapping("/api/v1/host")
@RequiredArgsConstructor
public class HostApi {

    private final HostJoinService hostJoinService;

    @PostMapping
    public SuccessResponse create(@Valid @RequestBody JoinDto.HostBasicReq req) {

        JoinDto.HostBasicRes res = hostJoinService.create(req);
        return SuccessResponse.success(res);
    }
}
