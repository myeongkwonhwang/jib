package com.j2kb.jibapi.domain.user.enums;

import lombok.Getter;

@Getter
public enum TokenType {

    ACCESS_TOKEN(60L * 30),
    REFRESH_TOKEN(60L * 60 * 24 * 14);

    private final Long validTime;

    TokenType(Long validTime) {
        this.validTime = validTime;
    }
}
