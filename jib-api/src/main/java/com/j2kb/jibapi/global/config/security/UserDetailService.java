package com.j2kb.jibapi.global.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by mkhwang on 2021/04/28
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@Slf4j
@Service
public class UserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
