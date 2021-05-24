package com.j2kb.jibapi.domain.user.dto;

import com.j2kb.jibapi.domain.user.entity.User;
import com.j2kb.jibapi.domain.user.enums.LoginType;
import com.j2kb.jibapi.domain.user.enums.UserType;
import lombok.*;

import javax.validation.constraints.NotNull;

public class UserDto {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class UpdateReq {

        @NotNull
        private Long id;

        private String firstName;

        private String lastName;

        private String phoneNumber;

        private String birthYear;

        private String languageCode;

    }


    @Data
   @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class UpdateRes{
        private Long id;

        private String firstName;

        private String lastName;

        private String phoneNumber;

        private String birthYear;

        private String languageCode;

        public static UpdateRes of(User user){
            return UpdateRes.builder()
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .phoneNumber(user.getPhoneNumber())
                    .birthYear(user.getBirthYear())
                    .languageCode(user.getLanguageCode()).build();
        }
    }
}
