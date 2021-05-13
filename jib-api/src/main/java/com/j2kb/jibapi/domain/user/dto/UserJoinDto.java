package com.j2kb.jibapi.domain.user.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * Created by mkhwang on 2021/05/01
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
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
        private UserDto.UserType usertype;

    }

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
        private UserDto.UserType usertype;
    }
}