package com.j2kb.jibapi.domain.user.enums;

import com.j2kb.jibapi.global.util.enumMapper.EnumMapperType;
import java.util.Arrays;

public enum LoginType implements EnumMapperType {
    BASIC("AA01", "basic"),
    GOOGLE("AA02", "google");

    private String code;
    private String description;

    LoginType(String code, String description) {
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

    public static LoginType findByCode(String code) {
        return Arrays.stream(LoginType.values())
            .filter(value -> value.getCode().equals(code))
            .findAny()
            .orElse(null);
    }
}
