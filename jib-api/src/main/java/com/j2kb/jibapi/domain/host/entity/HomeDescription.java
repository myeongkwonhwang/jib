package com.j2kb.jibapi.domain.host.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.j2kb.jibapi.domain.user.dto.EnrolHouseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@DynamoDBDocument
public class HomeDescription {
    private String homeType;
    private Offer offer;
    private List<String> homePictures;
    private String homeTitle;
    private List<String> nearbyFacilities;
    private List<String> homePolicy;
    private List<String> extraInfo;
}

