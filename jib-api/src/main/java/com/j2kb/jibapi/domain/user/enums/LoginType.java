package com.j2kb.jibapi.domain.user.enums;

import lombok.Getter;

@Getter
public enum LoginType {
    BASIC("AA01", "basic"),
    GOOGLE("AA02", "google");

    private String code;
    private String description;

    LoginType(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
