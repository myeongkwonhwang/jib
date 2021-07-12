package com.j2kb.jibapi.domain.host.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.j2kb.jibapi.domain.user.enums.CommonAreaType;
import com.j2kb.jibapi.domain.user.enums.FurnitureType;
import com.j2kb.jibapi.domain.user.enums.ServiceType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@DynamoDBDocument
public class Offer {
    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
    private List<FurnitureType> furniture;
    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
    private List<ServiceType> service;
    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
    private List<CommonAreaType> commonArea;
}
