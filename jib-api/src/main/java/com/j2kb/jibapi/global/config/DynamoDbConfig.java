package com.j2kb.jibapi.global.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories
public class DynamoDbConfig {

    //FIXME 왜 안될까

    @Value("${spring.dynamodb.endpoint}")
    private String amazonDynamoDbEndPoint;

    @Value("${amazon.aws.accesskey}")
    private String amazonDynamoDbAccessKey;

    @Value("${amazon.aws.secretkey}")
    private String amazonDynamoDbSecretKey;

    @Bean
    public DynamoDBMapper dynamoDbMapper(){
        return new DynamoDBMapper(buildAmazonDynamoDB());
    }
    private AmazonDynamoDB buildAmazonDynamoDB(){
        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(
                                amazonDynamoDbEndPoint, "ap-northeast-2"
                        )
                )
                .withCredentials(
                        new AWSStaticCredentialsProvider(
                                new BasicAWSCredentials(amazonDynamoDbAccessKey, amazonDynamoDbSecretKey)
                        )
                )
                .build();
    }



}
