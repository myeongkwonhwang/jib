package com.j2kb.jibapi.domain.user.enums;

import com.j2kb.jibapi.global.util.enumMapper.EnumMapperType;

import java.util.Arrays;

/**
 * Created by mkhwang on 2021/05/28
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
public enum Authority implements EnumMapperType {

    ROLE_STUDENT("student"), //유저-학생
    ROLE_HOST("host"),       //유저-호스트
    ROLE_ADMIN("admin");     //관리자

    private String description;

    Authority(String description) {
        this.description = description;
    }

    @Override
    public String getName() {
        return name();
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    public static Authority findByCode(String name) {
        return Arrays.stream(Authority.values())
                .filter(value -> name.equals(value.getName()))
                .findAny()
                .orElse(null);
    }

}
