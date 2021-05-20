package com.j2kb.jibapi.domain.user.enums;

import java.util.Arrays;

import com.j2kb.jibapi.global.util.enumMapper.EnumMapperType;
import lombok.Getter;

@Getter
public enum DistancePreference implements EnumMapperType {
    TEN("10"),
    TWENTY("20"),
    THIRTY("30"),
    ANY("Doesn't Matter");

    private String description;

    DistancePreference(String description) {
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

    public static DistancePreference findByCode(String name) {
        return Arrays.stream(DistancePreference.values())
                .filter(value -> name.equals(value.getName()))
                .findAny()
                .orElse(null);
    }
}