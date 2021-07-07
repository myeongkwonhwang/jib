package com.j2kb.jibapi.domain.user.service;

import com.j2kb.jibapi.domain.host.dao.HostRepository;
import com.j2kb.jibapi.domain.user.dto.EnrolHouseDto;
import com.j2kb.jibapi.global.config.security.UserPrincipal;
import com.j2kb.jibapi.global.enums.S3Directory;
import com.j2kb.jibapi.global.util.S3Uploader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class HouseEnrolService {

    public final HostRepository hostRepository;

    public final S3Uploader s3Uploader;

    @Transactional
    public void createHouse(EnrolHouseDto.EnrolReq req, List<MultipartFile> homePictures, UserPrincipal userPrincipal) {

        List<String> imageFilePathList = new ArrayList<>();

        for (MultipartFile homePictureImg : homePictures) {
            String uploadFullPath = s3Uploader.upload(homePictureImg, S3Directory.HOME.getDirName());
            imageFilePathList.add(uploadFullPath);
        }

        //req.toEntity();
    }
}
