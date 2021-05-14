package com.j2kb.jibapi.domain.user.dto;

import com.j2kb.jibapi.domain.user.enums.LoginType;
import com.j2kb.jibapi.domain.user.enums.UserType;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class UserJoinDto {
    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class BasicReq {
        @NotNull
        @Email
        private String email;

        @NotNull
        private String password;

        @NotNull
        private String firstname;

        @NotNull
        private String lastname;

        private String birthyear;

        private String langcd;

        private String phonenum;

        private String profileimg;

        @NotNull
        private LoginType logintype;

        @NotNull
        private UserType usertype;

    }

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class BasicRes {
        private String email;
        private String firstname;
        private String lastname;
        private LoginType logintype;
        private UserType usertype;
    }
}