package com.j2kb.jibapi.domain.user.enums;

import lombok.Getter;

@Getter
public enum UserType {
    STUDENT("AB01", "student"),
    PARENT("AB02", "parent"),
    WORKER("AB03", "worker"),
    HOST("AB04", "host");

    private String code;
    private String description;

    UserType(String code, String description) {
        this.code = code;
        this.description = description;
    }
}