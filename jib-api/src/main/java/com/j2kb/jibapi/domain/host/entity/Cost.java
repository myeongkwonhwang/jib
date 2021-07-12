package com.j2kb.jibapi.domain.host.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@DynamoDBDocument
public class Cost {
    private String monetaryUnit;
    private Integer baseRate;
    private Integer deposit;
    private Integer administrativeExpenses;
    private Integer foodExpenses;
}
