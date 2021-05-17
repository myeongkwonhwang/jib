package com.j2kb.jibapi.domain.user.enums;

import java.util.Arrays;

import com.j2kb.jibapi.global.util.enumMapper.EnumMapperType;
import lombok.Getter;

@Getter
public enum UserType implements EnumMapperType {
    STUDENT("AB01", "student"),
    PARENT("AB02", "parent"),
    WORKER("AB03", "worker"),
    HOST("AB04", "host");

    private String code;
    private String description;

    UserType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public String getName() {
        return name();
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public static UserType findByCode(String code) {
        return Arrays.stream(UserType.values())
            .filter(value -> value.getCode().equals(code))
            .findAny()
            .orElse(null);
    }
}