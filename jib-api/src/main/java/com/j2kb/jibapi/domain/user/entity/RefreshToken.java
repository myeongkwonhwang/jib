package com.j2kb.jibapi.domain.user.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@Setter
@RedisHash(value = "RefreshToken")
public class RefreshToken {

    @Id
    @Indexed
    private String token;

    @TimeToLive
    private long timeToLive;

    @Builder
    public RefreshToken(String token, long timeToLive) {
        this.token = token;
        this.timeToLive = timeToLive;
    }
}
