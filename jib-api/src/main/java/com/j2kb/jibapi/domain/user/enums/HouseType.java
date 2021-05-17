package com.j2kb.jibapi.domain.user.enums;

import java.util.Arrays;

import com.j2kb.jibapi.global.util.enumMapper.EnumMapperType;
import lombok.Getter;

@Getter
public enum HouseType implements EnumMapperType {
    ENTIRE("AD01", "entireHouse"),
    SHARED("AD02", "sharedHouse"),
    PRIVATE("AD03", "privateHouse"),
    NO_PREFERNCE("AD04", "noPreference");

    private String code;
    private String description;

    HouseType(String code, String description) {
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

    public static HouseType findByCode(String code) {
        return Arrays.stream(HouseType.values())
            .filter(value -> value.getCode().equals(code))
            .findAny()
            .orElse(null);
    }
}