package com.j2kb.jibapi.domain.host.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.j2kb.jibapi.domain.user.dto.EnrolHouseDto;
import lombok.*;

import java.util.List;

@DynamoDBDocument
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class HomeInfo {
    private Location location;
    private HomeDescription homeDescription;
    private List<String> keyword;
    private String occupablePeriod;
    private Integer minimumRequiredStay;
    private Cost cost;
    private HomeValidation homeValidation;
}
