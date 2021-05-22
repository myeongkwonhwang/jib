package com.j2kb.jibapi.domain.user.dto;

import com.j2kb.jibapi.domain.user.entity.User;
import com.j2kb.jibapi.domain.user.enums.LoginType;
import com.j2kb.jibapi.domain.user.enums.UserType;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class JoinDto {
    @Data
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
        private UserType userType;

        private String validationImg;

        private String authority;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class StudentReq {
        private Long userNo;
        @NotNull
        private Long dstNo;
        @NotNull
        private byte[] validationImg;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BasicRes {
        private Long userNo;
        private String email;
        private String firstName;
        private String lastName;
        private LoginType loginType;
        private UserType userType;
        private String authority;

        public static BasicRes of(User user) {
            return BasicRes.builder()
                .userNo(user.getUserNo())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .loginType(LoginType.findByCode(user.getLoginType()))
                .userType(UserType.findByCode(user.getUserType()))
                .build();
        }
    }
}