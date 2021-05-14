package com.j2kb.jibapi.domain.user.dto;

import com.j2kb.jibapi.domain.user.entity.User;
import com.j2kb.jibapi.domain.user.enums.LoginType;
import com.j2kb.jibapi.domain.user.enums.UserType;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserJoinDto {
    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class BasicReq {

        @Autowired
        protected static ModelMapper modelMapper;

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