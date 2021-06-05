package com.j2kb.jibapi.global.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by mkhwang on 2021/06/06
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@Component
@Slf4j
public class AuthenticationFacadeImpl implements AuthenticationFacade {

    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @Override
    public String getUserEmail() {
        return getAuthentication().getName();
    }

    @Override
    public UserPrincipal getUserPrincipal() {
        return (UserPrincipal) getAuthentication().getPrincipal();
    }
}
