package com.j2kb.jibapi.domain.user.enums;

import com.j2kb.jibapi.global.util.enumMapper.EnumMapperType;
import java.util.Arrays;

public enum LoginType implements EnumMapperType {
    BASIC("basic"),
    GOOGLE("google");

    private String description;

    LoginType(String description) {
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

    public static LoginType findByCode(String name) {
        return Arrays.stream(LoginType.values())
                .filter(value -> name.equals(value.getName()))
                .findAny()
                .orElse(null);
    }
}
