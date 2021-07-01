package com.j2kb.jibapi.domain.user.service;

import com.j2kb.jibapi.domain.interfaces.BasicServiceSupport;
import com.j2kb.jibapi.domain.user.dao.UserRepository;
import com.j2kb.jibapi.domain.user.dto.JoinDto;
import com.j2kb.jibapi.domain.user.entity.User;
import com.j2kb.jibapi.domain.user.enums.StateType;
import com.j2kb.jibapi.global.enums.S3Directory;
import com.j2kb.jibapi.global.config.security.UserPrincipal;
import com.j2kb.jibapi.global.error.exception.ErrorCode;
import com.j2kb.jibapi.global.error.exception.InvalidValueException;
import com.j2kb.jibapi.global.util.S3Uploader;
import java.io.IOException;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserJoinService extends BasicServiceSupport {

    private final UserRepository userRepository;

    private final S3Uploader s3Uploader;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserLoginService userLoginService;

    @Transactional
    public JoinDto.BasicRes create(JoinDto.BasicReq userReq, MultipartFile profileImg) {
        String password = userReq.getPassword();
        controlParams(userReq);

        User user = modelMapper.map(userReq, User.class);

        if (!profileImg.isEmpty()) {
            user.setProfileImg(s3Uploader.upload(profileImg, S3Directory.PROFILE.getDirName()));
        }

        JoinDto.BasicRes res = modelMapper.map(userRepository.save(user), JoinDto.BasicRes.class);
        res.setToken(userLoginService.authenticate(UserPrincipal.create(user), password));
        return res;
    }

    private void controlParams(JoinDto.BasicReq userReq) {
        userReq.setPassword(bCryptPasswordEncoder.encode(userReq.getPassword()));
    }

    /*
    private void controlValidationImg(JoinDto.BasicReq userReq, User user) {
        if(user.getValidationImg() != null) {
            user.setValidationImg(userReq.getValidationImg().getBytes(StandardCharsets.UTF_8));
        }
    }
     */

    private User getUserByUserNo(Long userNo) {
        Optional<User> user = userRepository.findByUserNo(userNo);
        return user.orElseThrow(() -> new InvalidValueException(ErrorCode.ENTITY_NOT_FOUND));
    }

    public void delete(Long userNo){
        User user = getUserByUserNo(userNo);
        user.setState(StateType.DELETED.getName());
        userRepository.save(user);
    }

    public JoinDto.BasicRes addAdditionalInfo(JoinDto.StudentReq studentReq) {
        User user = userRepository.findById(studentReq.getUserNo())
                .orElseThrow(() -> new InvalidValueException(ErrorCode.ENTITY_NOT_FOUND));

        controlAdditionalInfo(studentReq, user);
        return JoinDto.BasicRes.of(userRepository.save(user));
    }

    private void controlAdditionalInfo(JoinDto.StudentReq studentReq, User user) {
        user.setValidationImg(studentReq.getValidationImg());
        //user.setDstNo(studentReq.getDstNo());
        user.setPhotoProvided(true);
    }
    
}