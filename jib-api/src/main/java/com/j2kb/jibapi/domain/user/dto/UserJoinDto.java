package com.j2kb.jibapi.domain.user.dto;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import lombok.*;

import org.springframework.web.bind.annotation.RequestBody;

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
        private String firstName;

        @NotNull
        private String lastName;

        private String birthYear;

        private String langCd;

        private String phoneNum;

        private String profileImg;

        @NotNull
        private LoginType loginType;

        @NotNull
        private UserDto.UserType userType;

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
        private String firstName;
        private String lastName;
        private LoginType loginType;
        private UserDto.UserType userType;
    }
}