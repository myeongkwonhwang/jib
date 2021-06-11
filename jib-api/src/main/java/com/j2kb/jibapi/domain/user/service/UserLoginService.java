package com.j2kb.jibapi.domain.user.service;

import com.j2kb.jibapi.global.config.security.jwt.TokenProvider;
import com.j2kb.jibapi.domain.user.dao.UserRepository;
import com.j2kb.jibapi.domain.user.dto.LoginDto;
import com.j2kb.jibapi.domain.user.entity.User;
import com.j2kb.jibapi.global.config.security.UserPrincipal;
import com.j2kb.jibapi.global.error.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by mkhwang on 2021/06/02
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserLoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    private final AuthenticationManager authenticationManager;

    public String authorize(LoginDto.Req req) {
        User user = findByEmailAndPassword(req);
        return this.authenticate(UserPrincipal.create(user), req.getPassword());
    }

    private User findByEmailAndPassword(LoginDto.Req req) {
        User user = findByEmail(req.getEmail());
        if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return user;
    }

    private User findByEmail(String email) {
        log.info("findByEmail: email = " + email);
        return userRepository.findByEmail(email)
                .orElseThrow(()-> new EntityNotFoundException("일치하는 회원정보가 없습니다."));
    }

    public String authenticate(UserPrincipal userPrincipal, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userPrincipal
                        , password
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return tokenProvider.genarateToken();
    }

}
