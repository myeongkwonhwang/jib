package com.j2kb.jibapi.domain.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import lombok.Data;

public class LoginDto {
    @Data
    public static class Req {

        @NotNull
        @Email
        private String email;

        @NotNull
        private String password;

    }

    @Data
    public static class Res {

        private String email;

    }
}

