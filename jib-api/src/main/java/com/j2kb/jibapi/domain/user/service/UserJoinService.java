package com.j2kb.jibapi.domain.user.service;

import com.j2kb.jibapi.domain.interfaces.BasicServiceSupport;
import com.j2kb.jibapi.domain.user.dao.UserRepository;
import com.j2kb.jibapi.domain.user.dto.JoinDto;
import com.j2kb.jibapi.domain.user.entity.User;
import com.j2kb.jibapi.global.common.SuccessResponse;
import com.j2kb.jibapi.global.error.exception.ErrorCode;
import com.j2kb.jibapi.global.error.exception.InvalidValueException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
<<<<<<< HEAD
import java.util.Optional;
=======
import java.nio.charset.StandardCharsets;
>>>>>>> 57a26a9ec839f444debe02c65ea02f4f250c129f

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
    public User getUserByUserno(Integer userno) {
        Optional<User> user = userRepository.findById(userno);
        if(user.isEmpty()) throw new InvalidValueException(ErrorCode.ENTITY_NOT_FOUND);
        return user.get();
    }
    public SuccessResponse delete(Integer userno){
        User user = getUserByUserno(userno);
        user.setState(0);
        System.out.println(user.getState());
        System.out.println(user.getEmail());
        return new SuccessResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }

}
