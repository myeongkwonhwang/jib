package com.j2kb.jibapi.global.config.security;

import com.j2kb.jibapi.domain.jwt.JwtUser;
import com.j2kb.jibapi.domain.user.dao.UserRepository;
import com.j2kb.jibapi.domain.user.dto.LoginDto;
import com.j2kb.jibapi.domain.user.entity.User;
import com.j2kb.jibapi.global.error.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        return new JwtUser(findByEmail(email));
    }

    public User findByEmail(String email) {
        System.out.println("findByEmail: email = " + email);
        return userRepository.findByEmail(email)
            .orElseThrow(()-> new EntityNotFoundException("일치하는 회원정보가 없습니다."));
    }

    public User findByEmailAndPassword(LoginDto.Req req) {
        User user = findByEmail(req.getEmail());

        if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return null;
    }
}
