package com.j2kb.jibapi.domain.user.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@Setter
@RedisHash(value = "RefreshToken", timeToLive = 60 * 5)
public class RefreshToken {

    @Id
    @Indexed
    private String token;

    @Builder
    public RefreshToken(String token) {
        this.token = token;
    }
}
