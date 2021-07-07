package com.j2kb.jibapi.domain.user.service;

import com.j2kb.jibapi.domain.interfaces.BasicServiceSupport;
import com.j2kb.jibapi.domain.user.dao.UserRepository;
import com.j2kb.jibapi.domain.user.dto.JoinDto;
import com.j2kb.jibapi.domain.user.entity.User;
import com.j2kb.jibapi.domain.user.service.UserLoginService;
import com.j2kb.jibapi.global.config.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by mkhwang on 2021/06/06
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class HostJoinService extends BasicServiceSupport {

    private final UserRepository userRepository;
    private final UserLoginService userLoginService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public JoinDto.HostBasicRes create(JoinDto.HostBasicReq req) {
        String password = req.getPassword();
        req.setPassword(bCryptPasswordEncoder.encode(req.getPassword()));

        User user = userRepository.save(modelMapper.map(req, User.class));
        JoinDto.HostBasicRes res = modelMapper.map(user, JoinDto.HostBasicRes.class);
        res.setToken(userLoginService.authenticate(UserPrincipal.create(user), password));
        return res;
    }
}
