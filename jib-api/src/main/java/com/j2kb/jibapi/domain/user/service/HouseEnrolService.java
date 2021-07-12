package com.j2kb.jibapi.domain.user.service;


import com.j2kb.jibapi.domain.host.dao.HostRepository;
import com.j2kb.jibapi.domain.host.entity.HomeDescription;
import com.j2kb.jibapi.domain.host.entity.HomeInfo;
import com.j2kb.jibapi.domain.host.entity.Host;
import com.j2kb.jibapi.domain.user.dto.EnrolHouseDto;
import com.j2kb.jibapi.global.config.security.AuthenticationFacade;
import com.j2kb.jibapi.global.config.security.UserPrincipal;
import com.j2kb.jibapi.global.enums.S3Directory;
import com.j2kb.jibapi.global.util.S3Uploader;
import com.j2kb.jibapi.domain.interfaces.BasicServiceSupport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class HouseEnrolService extends BasicServiceSupport {

    public final HostRepository hostRepository;

    public final S3Uploader s3Uploader;

    public final AuthenticationFacade authenticationFacade;

    @Transactional
    public void createHouse(EnrolHouseDto.HomeInfo req) {
        HomeInfo homeInfo = modelMapper.map(req, HomeInfo.class);

       // List<String> imageFilePathList = new ArrayList<>();

//        for (MultipartFile homePictureImg : homePictures) {
//            String uploadFullPath = s3Uploader.upload(homePictureImg, S3Directory.HOME.getDirName());
//            imageFilePathList.add(uploadFullPath);
//        }
//
//        if(imageFilePathList != null && imageFilePathList.size() > 0){
//            HomeDescription homeDescription = homeInfo.getHomeDescription();
//            homeDescription.setHomePictures(imageFilePathList);
//        }

        Host host = new Host();
        //host.setUserno(String.valueOf(userPrincipal.getUserNo()));
        host.setHomeInfo(homeInfo);

        hostRepository.save(host);
    }
//    public void createHouse(EnrolHouseDto.EnrolReq req, List<MultipartFile> homePictures, UserPrincipal userPrincipal) {
//        System.out.println(req);
//        List<String> imageFilePathList = new ArrayList<>();
//
////        for (MultipartFile homePictureImg : homePictures) {
////            String uploadFullPath = s3Uploader.upload(homePictureImg, S3Directory.HOME.getDirName());
////            imageFilePathList.add(uploadFullPath);
////        }
//
//    }




}
