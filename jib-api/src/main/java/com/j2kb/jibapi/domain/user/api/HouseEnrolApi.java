package com.j2kb.jibapi.domain.user.api;

import com.j2kb.jibapi.domain.host.entity.HomeInfo;
import com.j2kb.jibapi.domain.host.entity.Host;
import com.j2kb.jibapi.domain.user.dto.EnrolHouseDto;
import com.j2kb.jibapi.domain.user.service.HouseEnrolService;
import com.j2kb.jibapi.global.common.SuccessResponse;
import com.j2kb.jibapi.global.config.security.AuthenticationFacade;
import com.j2kb.jibapi.global.config.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/house")
@RequiredArgsConstructor
public class HouseEnrolApi {

    private final HouseEnrolService houseEnrolService;
    private final AuthenticationFacade authenticationFacade;

    @PostMapping
    public SuccessResponse houseEnrol(@Valid @RequestBody EnrolHouseDto.HomeInfo req){

        //UserPrincipal userPrincipal = authenticationFacade.getUserPrincipal();
        houseEnrolService.createHouse(req);
        System.out.println(req);
        return SuccessResponse.success();
    }
//    public SuccessResponse houseEnrol(@Valid @RequestBody EnrolHouseDto.EnrolReq req, @RequestPart List<MultipartFile> homePictures){
//
//        UserPrincipal userPrincipal = authenticationFacade.getUserPrincipal();
//        houseEnrolService.createHouse(req, homePictures, userPrincipal);
//        return SuccessResponse.success();
//    }



}
