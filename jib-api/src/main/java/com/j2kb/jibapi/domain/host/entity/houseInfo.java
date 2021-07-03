package com.j2kb.jibapi.domain.host.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import java.util.List;
import java.util.Map;

@DynamoDBDocument
public class houseInfo {
    //front 팀에서 준 스키마에는 여기에 id를 갖고있는데 우리는 테이블의 해시키 자체가 집을 구분하기 때문에 따로 필요없을
    //private String id;

    @DynamoDBAttribute
    private String hostId;

    @DynamoDBAttribute
    private location location;

    @DynamoDBAttribute
    private String religion;

    @DynamoDBAttribute
    private payment payment;

    @DynamoDBAttribute
    private documentValidation validateDocument;

    @DynamoDBAttribute
    private List<String> availability;

    private houseDescription houseDescription;
}
