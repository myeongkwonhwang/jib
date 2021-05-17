package com.j2kb.jibapi.domain.user.enums;

import java.util.Arrays;

import com.j2kb.jibapi.global.util.enumMapper.EnumMapperType;
import lombok.Getter;

@Getter
public enum DistancePreference implements EnumMapperType {
    TEN("AC01", "10"),
    TWENTY("AC02", "20"),
    THIRTY("AC03", "30"),
    ANY("AC04", "Doesn't Matter");

    private String code;
    private String description;

    DistancePreference(String code, String description) {
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

    public static DistancePreference findByCode(String code) {
        return Arrays.stream(DistancePreference.values())
            .filter(value -> value.getCode().equals(code))
            .findAny()
            .orElse(null);
    }
}