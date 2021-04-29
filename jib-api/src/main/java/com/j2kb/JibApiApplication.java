package com.j2kb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.j2kb.jibapi.*") //JPA Entity Scan
public class JibApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(JibApiApplication.class, args);
    }

}
