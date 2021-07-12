package com.j2kb.jibapi.domain.host.entity;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamoDBDocument
public class Location {
    private String country;
    private String province;
    private String city;
    private String homeAddress;
    private String detailAddress;
    private String zipCode;
    private String lat;
    private String lng;
}
