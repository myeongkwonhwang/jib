package com.j2kb.jibapi.domain.user.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@Setter
@RedisHash(value = "PasswordResetToken", timeToLive = 60 * 5)
public class PasswordResetToken {

    @Id
    @Indexed
    private String email;
    private String token;

    @Builder
    public PasswordResetToken(String email, String token) {
        this.email = email;
        this.token = token;
    }
}
