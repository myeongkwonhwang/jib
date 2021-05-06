package com.j2kb.jibapi.domain.interfaces;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by mkhwang on 2021/05/06
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@Slf4j
public class BasicServiceSupport {

    @Autowired
    protected BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    protected ModelMapper modelMapper;

    public String bcryptEnc(String target) {
        return bCryptPasswordEncoder.encode(target);
    }
}
