package com.j2kb.jibapi.domain.host.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@DynamoDBDocument
public class HomeValidation {
    private Boolean isValidate;
    private List<String> documents;
}
