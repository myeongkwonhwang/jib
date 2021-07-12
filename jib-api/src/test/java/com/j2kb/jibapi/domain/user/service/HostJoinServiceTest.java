package com.j2kb.jibapi.domain.user.service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.j2kb.jibapi.domain.user.dto.JoinDto;
import com.j2kb.jibapi.domain.user.enums.LoginType;
import com.j2kb.jibapi.domain.user.enums.UserType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Slf4j
class HostJoinServiceTest {

    @Autowired
    HostJoinService hostJoinService;

    @PersistenceContext
    EntityManager entityManager;

    BigInteger getUserSequence() {
        return (BigInteger) entityManager.createNativeQuery("select currval('jib.user_user_no_seq')").getSingleResult();
    }

    @Autowired
    AmazonDynamoDB amazonDynamoDB;
//
//   @Test
//   void hostTableTest(){
////       Table table = dynamoDB.getTable("home");
//
//       Item item = table.getItem("id", "1");
//
//
//       System.out.println(item.toJSONPretty());
//   }

    @Test
    void hostTableInsertTest() {
        DynamoDB dynamoDB = new DynamoDB(amazonDynamoDB);
        Table table = dynamoDB.getTable("home");
        Item item = new Item().withPrimaryKey("id", "12").withString("title","title");
        table.putItem(item);
    }




    @Test
    void hostCreateTest() {

        JoinDto.HostBasicReq req = JoinDto.HostBasicReq.builder()
                .email("orange2653@gmail.com")
                .password("tg0850")
                .firstName("myeongkwon")
                .lastName("hwang")
                .birthYear("1990")
                .loginType(LoginType.BASIC)
                .userType(UserType.HOST)
                .build();

        JoinDto.HostBasicRes hostBasicRes = hostJoinService.create(req);
        Long userSequence = this.getUserSequence().longValue();
        assertAll(
                () -> assertEquals(hostBasicRes.getUserNo(), userSequence),
                () -> assertEquals(hostBasicRes.getEmail(), "orange2653@gmail.com"),
                () -> assertNotNull(hostBasicRes.getToken())
        );

    }

}
