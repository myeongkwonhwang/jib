package com.j2kb.jibapi.domain.user.enums;

import lombok.Getter;

@Getter
public enum DistancePreference {
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
}