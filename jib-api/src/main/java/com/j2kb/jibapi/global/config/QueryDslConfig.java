package com.j2kb.jibapi.global.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by mkhwang on 2021/05/21
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@Configuration
public class QueryDslConfig {

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory queryFactory() {
        return new JPAQueryFactory(entityManager);
    }
}
