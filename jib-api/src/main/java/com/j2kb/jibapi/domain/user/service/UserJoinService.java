package com.j2kb.jibapi.domain.user.service;

import com.j2kb.jibapi.domain.interfaces.BasicServiceSupport;
import com.j2kb.jibapi.domain.user.dao.UserRepository;
import com.j2kb.jibapi.domain.user.dto.UserJoinDto;
import com.j2kb.jibapi.domain.user.entity.User;
import com.j2kb.jibapi.domain.user.dto.UserJoinDto;
import com.j2kb.jibapi.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserJoinService extends BasicServiceSupport {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserJoinDto.BasicRes create(@RequestBody @Valid UserJoinDto.BasicReq userReq) {
        basicReqControlParams(userReq);
        User user = basicJoinReqToUser(userReq);
        saveUser(user);
        return userToBasicRes(user);
    }

    private void basicReqControlParams(UserJoinDto.BasicReq userReq) {
        userReq.setPassword(bCryptPasswordEncoder.encode(userReq.getPassword()));
    }

    private User basicJoinReqToUser(UserJoinDto.BasicReq userReq) {
        User user = modelMapper.map(userReq, User.class);
        return user;
    }

    private void saveUser(User user) {
        userRepository.save(user);
    }

    private UserJoinDto.BasicRes userToBasicRes(User user) {
        return modelMapper.map(user, UserJoinDto.BasicRes.class);
    }
}
