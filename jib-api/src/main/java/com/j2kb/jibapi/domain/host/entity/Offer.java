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

    @DynamoDBTypeConvertedEnum
    private List<FurnitureType> furniture;
    @DynamoDBTypeConvertedEnum
    private List<ServiceType> service;
    @DynamoDBTypeConvertedEnum
    private List<CommonAreaType> commonArea;
}
