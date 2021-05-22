package com.j2kb.jibapi.domain.user.service;

import com.j2kb.jibapi.domain.user.dto.JoinDto;
import com.j2kb.jibapi.domain.user.enums.LoginType;
import com.j2kb.jibapi.domain.user.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by mkhwang on 2021/05/22
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@SpringBootTest
@Transactional
@Slf4j
class UserJoinServiceTest {

    @Autowired
    UserJoinService userJoinService;
    @Autowired
    EntityManager entityManager;


    @BeforeEach
    public void beforeEach() {
        this.entityManager.createNativeQuery("ALTER TABLE user ALTER COLUMN `user_no` RESTART WITH 1")
                .executeUpdate();
    }

    @Test
    void createTest() {
        //given
        JoinDto.BasicReq req = JoinDto.BasicReq.builder()
                .email("hayeon@gmail.com")
                .password("1111")
                .firstName("hayeon")
                .lastName("kim")
                .loginType(LoginType.BASIC)
                .userType(UserType.STUDENT).build();

        JoinDto.BasicRes res = JoinDto.BasicRes.builder()
                .email("hayeon@gmail.com")
                .firstName("hayeon")
                .lastName("kim")
                .loginType(LoginType.BASIC)
                .userType(UserType.STUDENT)
                .build();

        JoinDto.BasicRes basicRes = userJoinService.create(req);

        log.info(basicRes.toString());

        assertAll(
                () -> assertEquals(basicRes.getEmail(), res.getEmail()),
                () -> assertEquals(basicRes.getLoginType(), res.getLoginType())
        );
    }

    @Test
    void createTest_two() {
        //given
        JoinDto.BasicReq req = JoinDto.BasicReq.builder()
                .email("hayeon@gmail.com")
                .password("1111")
                .firstName("hayeon")
                .lastName("kim")
                .loginType(LoginType.BASIC)
                .userType(UserType.STUDENT).build();


        JoinDto.BasicRes res = JoinDto.BasicRes.builder()
                .email("hayeon@gmail.com")
                .firstName("hayeon")
                .lastName("kim")
                .loginType(LoginType.BASIC)
                .userType(UserType.STUDENT)
                .build();

        JoinDto.BasicRes basicRes = userJoinService.create(req);

        log.info(basicRes.toString());

        assertAll(
                () -> assertEquals(basicRes.getEmail(), res.getEmail()),
                () -> assertEquals(basicRes.getLoginType(), res.getLoginType())
        );
    }
}