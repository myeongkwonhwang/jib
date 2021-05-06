package com.j2kb.jibapi.domain.member.api;

import com.j2kb.jibapi.domain.member.dto.MemberJoinDto;
import com.j2kb.jibapi.domain.member.service.MemberJoinService;
import com.j2kb.jibapi.global.common.SuccessResponse;
import io.swagger.annotations.ApiOperation;
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

    //Constructor Injection
    private final MemberJoinService memberJoinService;

    /* @AllArgsConstructor
    public MemberApi(MemberJoinService memberJoinService) {
        this.memberJoinService = memberJoinService;
    }
    사용하는 이유 field Injection
    @Autowired 선언 아래 3개든 10개든 막 추가할 수 있다.
    여기서 Constructor Injection을 사용하면 다른 Injection 타입에 비해 위기감 같은 걸 느끼게 해준다.
    Constructor의 파라미터가 많아짐과 동시에 하나의 클래스가 많은 책임을 떠안는다는 걸 알게된다.
    */

    @PostMapping
    @ApiOperation(value = "기본회원가입")
    public SuccessResponse save(@Valid @RequestBody MemberJoinDto.BasicReq basicReq) {
        MemberJoinDto.BasicRes basicRes = memberJoinService.save(basicReq);
        return SuccessResponse.success(basicRes);
    }
}
