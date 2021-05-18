package com.j2kb.jibapi.domain.user.service;

import com.j2kb.jibapi.domain.interfaces.BasicServiceSupport;
import com.j2kb.jibapi.domain.user.dao.UserRepository;
import com.j2kb.jibapi.domain.user.dto.JoinDto;
import com.j2kb.jibapi.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserJoinService extends BasicServiceSupport {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public JoinDto.BasicRes create(@RequestBody @Valid JoinDto.BasicReq userReq) {
        controlParams(userReq);
        User user = modelMapper.map(userReq, User.class);
        user.setValidationImg(userReq.getValidationImg().getBytes(StandardCharsets.UTF_8));
        return modelMapper.map(userRepository.save(user), JoinDto.BasicRes.class);
    }

    private void controlParams(JoinDto.BasicReq userReq) {
        userReq.setPassword(bCryptPasswordEncoder.encode(userReq.getPassword()));
    }

}
