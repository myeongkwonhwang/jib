package com.j2kb.jibapi.domain.user.api;

import com.j2kb.jibapi.domain.user.dto.JoinDto;
import com.j2kb.jibapi.domain.user.service.UserJoinService;
import com.j2kb.jibapi.domain.user.service.UserUpdateService;
import com.j2kb.jibapi.global.common.SuccessResponse;
import com.j2kb.jibapi.global.error.exception.EntityNotFoundException;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
@Slf4j
@RequiredArgsConstructor
public class UserApi {

    private final UserJoinService userJoinService;
    private final UserUpdateService userUpdateService;

    @PostMapping
    @ApiOperation(value = "기본회원가입")
    public SuccessResponse join(@Valid @RequestBody JoinDto.BasicReq basicReq) {
        JoinDto.BasicRes basicRes = userJoinService.create(basicReq);
        return SuccessResponse.success(basicRes);
    }

    @PostMapping("/student")
    @ApiOperation(value = "학생 회원가입 시 추가정보 추가")
    public SuccessResponse addAdditionalInfo(@Valid @RequestBody JoinDto.StudentReq studentReq) {
        JoinDto.BasicRes basicRes = userJoinService.addAdditionalInfo(studentReq);
        return SuccessResponse.success(basicRes);
    }

    @PostMapping("/login")
    @ApiOperation(value = "로그인")
    public SuccessResponse login(@Valid @RequestBody JoinDto.BasicReq basicReq) {
        JoinDto.BasicRes basicRes = userJoinService.create(basicReq);
        return SuccessResponse.success(basicRes);
    }

    @DeleteMapping("/{userNo}")
    @ApiOperation(value = "회원탈퇴")
    @ApiImplicitParam(name = "userNo", value = "유저 고유번호", required = true)
    public SuccessResponse delete(@PathVariable("userNo") Long userNo){
        userJoinService.delete(userNo);
        return SuccessResponse.success();
    }

    @PatchMapping("/{userNo}")
    @ApiOperation(value="회원정보수정")
    @ApiImplicitParam(name = "userNo", value = "유저 고유번호", required = true)
    public SuccessResponse update(@PathVariable("userNo") Long userNo, @Valid @RequestBody JoinDto.BasicReq basicReq){
//        if(userJoinService.update(basicReq, userNo)){
//            return SuccessResponse.success();
//        }else{
//            throw new EntityNotFoundException("target user does not exists!");
//        }
        return null;
    }



}
