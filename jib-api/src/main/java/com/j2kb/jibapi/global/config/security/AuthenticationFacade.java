package com.j2kb.jibapi.global.config.security;

import org.springframework.security.core.Authentication;

/**
 * Created by mkhwang on 2021/06/06
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
public interface AuthenticationFacade {

    Authentication getAuthentication();

    String getUserEmail();

    UserPrincipal getUserPrincipal();

}
