package com.j2kb.jibapi.domain.interfaces;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by mkhwang on 2021/05/06
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@Slf4j
public class BasicServiceSupport {

    @Autowired
    protected ModelMapper modelMapper;

}
