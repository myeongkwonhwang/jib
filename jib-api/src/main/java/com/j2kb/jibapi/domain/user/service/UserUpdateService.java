package com.j2kb.jibapi.domain.user.service;

import com.j2kb.jibapi.domain.interfaces.BasicServiceSupport;
import com.j2kb.jibapi.domain.user.dao.UserRepository;
import com.j2kb.jibapi.domain.user.dto.JoinDto;
import com.j2kb.jibapi.domain.user.entity.User;
import com.j2kb.jibapi.global.error.exception.EntityNotFoundException;
import com.j2kb.jibapi.global.util.S3Uploader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserUpdateService extends BasicServiceSupport {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public JoinDto.BasicRes update(JoinDto.BasicReq userReq, Long userNo) {
        User user = userRepository.findById(userNo).orElseThrow(
                () -> new EntityNotFoundException("해당 유저를 조회할 수 없습니다.")
        );
        user.update(userReq);

        return modelMapper.map(userRepository.save(user), JoinDto.BasicRes.class);
    }

    public void updatePassword(String email, String password) {
        User user = userRepository.findByEmail(email).orElseThrow(
            () -> new EntityNotFoundException("해당 유저를 조회할 수 없습니다.")
        );
        user.setPassword(bCryptPasswordEncoder.encode(password));
        userRepository.save(user);
    }
}
