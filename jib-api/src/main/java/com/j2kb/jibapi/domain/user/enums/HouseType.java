package com.j2kb.jibapi.domain.user.enums;

import java.util.Arrays;

import com.j2kb.jibapi.global.util.enumMapper.EnumMapperType;
import lombok.Getter;

@Getter
public enum HouseType implements EnumMapperType {
    ENTIRE("entireHouse"),
    SHARED("sharedHouse"),
    PRIVATE("privateHouse"),
    NO_PREFERNCE("noPreference");

    private String description;

    HouseType(String description) {
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

    public static HouseType findByCode(String name) {
        return Arrays.stream(HouseType.values())
                .filter(value -> name.equals(value.getName()))
                .findAny()
                .orElse(null);
    }
}