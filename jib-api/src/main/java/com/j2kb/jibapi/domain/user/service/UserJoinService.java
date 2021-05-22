package com.j2kb.jibapi.domain.user.service;

import com.j2kb.jibapi.domain.destination.service.DestinationService;
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
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
@Slf4j
public class UserJoinService extends BasicServiceSupport {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public JoinDto.BasicRes create(@RequestBody @Valid JoinDto.BasicReq userReq) {
        controlParams(userReq);
        User user = modelMapper.map(userReq, User.class);
        controlValidationImg(userReq, user);
        return modelMapper.map(userRepository.save(user), JoinDto.BasicRes.class);
    }

    private void controlParams(JoinDto.BasicReq userReq) {
        userReq.setPassword(bCryptPasswordEncoder.encode(userReq.getPassword()));
    }

    private void controlValidationImg(JoinDto.BasicReq userReq, User user) {
        if(user.getValidationImg() != null) {
            user.setValidationImg(userReq.getValidationImg().getBytes(StandardCharsets.UTF_8));
        }
    }

    public User getUserByUserNo(Long userNo) {
        Optional<User> user = userRepository.findById(userNo);

        return user.orElseThrow(() -> new InvalidValueException(ErrorCode.ENTITY_NOT_FOUND));
    }

    public SuccessResponse delete(Long userNo){
        User user = getUserByUserNo(userNo);
        user.setState(StateType.DELETED.getName());
        userRepository.save(user);
        return new SuccessResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }

    public JoinDto.BasicRes addAdditionalInfo(JoinDto.StudentReq studentReq) {
        User user = userRepository.findById(studentReq.getUserNo())
                .orElseThrow(() -> new InvalidValueException(ErrorCode.ENTITY_NOT_FOUND));

        controlAdditionalInfo(studentReq, user);
        return JoinDto.BasicRes.of(userRepository.save(user));
    }

    private void controlAdditionalInfo(JoinDto.StudentReq studentReq, User user) {
        user.setValidationImg(studentReq.getValidationImg());
        user.setDstNo(studentReq.getDstNo());
        user.setPhotoProvided(true);
    }
}