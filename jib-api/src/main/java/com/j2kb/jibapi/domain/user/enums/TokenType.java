package com.j2kb.jibapi.domain.user.enums;

import lombok.Getter;

@Getter
public enum TokenType {

    ACCESS_TOKEN(60L * 30, "access token"),
    REFRESH_TOKEN(60L * 60 * 24 * 14, "refresh token");

    public final Long validTime;
    public final String description;

    TokenType(Long validTime, String description) {
        this.validTime = validTime;
        this.description = description;
    }
}
