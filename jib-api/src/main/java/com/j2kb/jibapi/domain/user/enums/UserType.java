package com.j2kb.jibapi.domain.user.enums;

import java.util.Arrays;

import com.j2kb.jibapi.global.util.enumMapper.EnumMapperType;
import lombok.Getter;

@Getter
public enum UserType implements EnumMapperType {
    STUDENT("student"),
    PARENT("parent"),
    WORKER("worker"),
    HOST("host");

    private String description;

    UserType(String description) {
        this.description = description;
    }

    @Override
    public String getName() {
        return name();
    }

    @Override
    public String getDescription() {
        return description;
    }

    public static UserType findByCode(String name) {
        return Arrays.stream(UserType.values())
                .filter(value -> name.equals(value.getName()))
                .findAny()
                .orElse(null);
    }
}