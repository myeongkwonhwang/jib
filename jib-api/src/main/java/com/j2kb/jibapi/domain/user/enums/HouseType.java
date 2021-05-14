package com.j2kb.jibapi.domain.user.enums;

import lombok.Getter;

@Getter
public enum HouseType {
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
}