package com.j2kb.jibapi.global.enums;

import lombok.Getter;

@Getter
public enum S3Directory {

    PROFILE("profile", "user profile image"),
    VERIFICATION("verification", "image for verifying user identity"),
    HOME("home", "home image");

    private String dirName;
    private String description;

    S3Directory(String dirName, String description) {
        this.dirName = dirName;
        this.description = description;
    }

}
