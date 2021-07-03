package com.j2kb.jibapi.domain.host.api;

import com.j2kb.jibapi.domain.host.service.HouseEnrolService;
import com.j2kb.jibapi.global.common.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/house")
@RequiredArgsConstructor
public class HouseEnrolApi {

    private final HouseEnrolService houseEnrolService;


}
