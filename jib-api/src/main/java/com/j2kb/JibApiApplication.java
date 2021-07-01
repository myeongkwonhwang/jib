package com.j2kb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EntityScan("com.j2kb.jibapi.*") //JPA Entity Scan
@EnableRedisRepositories(basePackages = "com.j2kb.jibapi.domain.user.dao")
public class JibApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(JibApiApplication.class, args);
    }

}
