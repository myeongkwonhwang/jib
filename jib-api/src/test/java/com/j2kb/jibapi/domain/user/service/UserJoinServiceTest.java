package com.j2kb.jibapi.domain.user.service;

import com.j2kb.jibapi.domain.user.dto.JoinDto;
import com.j2kb.jibapi.domain.user.enums.LoginType;
import com.j2kb.jibapi.domain.user.enums.UserType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    UserUpdateService userUpdateService;
    @PersistenceContext
    EntityManager entityManager;


    @BeforeEach
    public void beforeEach() {
        this.entityManager.createNativeQuery("ALTER TABLE jib.user ALTER COLUMN user_no RESTART WITH 1")
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

    @Test
    void updateTest_fail(){
        //given
        JoinDto.BasicReq req1 = JoinDto.BasicReq.builder()
                .email("hayeon@gmail.com")
                .password("1111")
                .firstName("hayeon")
                .lastName("kim")
                .loginType(LoginType.BASIC)
                .userType(UserType.STUDENT).build();


        JoinDto.BasicReq req2 = JoinDto.BasicReq.builder()
                .email("hayeon@gmail.com")
                .firstName("dahoon")
                .lastName("kim")
                .loginType(LoginType.BASIC)
                .userType(UserType.STUDENT)
                .build();

        JoinDto.BasicRes basicRes = userJoinService.create(req1);

        //when
        //exist
        JoinDto.BasicRes basicRes2 = userUpdateService.update(req2, 1L);
        //non-exist
        //JoinDto.BasicRes basicRes2 = userJoinService.update(req2, 2L);


        //then
        log.info(String.valueOf(basicRes2));
        assertAll(
                ()-> assertNotEquals(req1.getFirstName(), basicRes2.getFirstName())
        );

    }

    @Test
    void updateTest_success(){
        //given
        JoinDto.BasicReq req1 = JoinDto.BasicReq.builder()
                .email("hayeon@gmail.com")
                .password("1111")
                .firstName("hayeon")
                .lastName("kim")
                .loginType(LoginType.BASIC)
                .userType(UserType.STUDENT).build();


        JoinDto.BasicReq req2 = JoinDto.BasicReq.builder()
                .email("hayeon@gmail.com")
                .firstName("dahoon")
                .lastName("kim")
                .loginType(LoginType.BASIC)
                .userType(UserType.STUDENT)
                .build();

        JoinDto.BasicRes basicRes = userJoinService.create(req1);

        //when
        JoinDto.BasicRes basicRes2 = userUpdateService.update(req2, 1L);


        //then
        log.info(String.valueOf(basicRes2));
        assertAll(
                ()-> assertEquals("dahoon", basicRes2.getFirstName())
        );

    }
}