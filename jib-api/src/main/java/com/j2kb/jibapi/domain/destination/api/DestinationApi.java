package com.j2kb.jibapi.domain.destination.api;

import com.j2kb.jibapi.domain.destination.service.DestinationService;
import com.j2kb.jibapi.global.common.SuccessResponse;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import com.j2kb.jibapi.domain.destination.dto.DestinationDto;

import javax.validation.Valid;

/**
 * Created by mkhwang on 2021/05/08
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@RestController
@RequestMapping(value = "/api/v1/destination")
@Slf4j
@RequiredArgsConstructor
public class DestinationApi {

    private final DestinationService destinationService;

    @PostMapping
    @ApiOperation(value = "목적지 저장")
    public SuccessResponse create(@RequestBody @Valid DestinationDto.SaveReq saveReq) {
        DestinationDto.SaveRes res = destinationService.create(saveReq);
        return SuccessResponse.success(res);
    }

    @GetMapping("/{dstNo}")
    @ApiOperation(value = "목적지 조회")
    public SuccessResponse search(@PathVariable Long dstNo) {
        DestinationDto.SaveRes res = destinationService.search(dstNo);
        return SuccessResponse.success(res);
    }
}
