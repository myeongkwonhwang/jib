package com.j2kb.jibapi.global.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.TimeZone;

@Configuration
@EnableDynamoDBRepositories
public class DynamoDbConfig {

    //FIXME 왜 안될까

    public static class LocalDateTimeConverter implements DynamoDBTypeConverter<Date, LocalDateTime>{
        @Override
        public Date convert(LocalDateTime src){
            return Date.from(src.toInstant(ZoneOffset.UTC));
        }
        @Override
        public LocalDateTime unconvert(Date src){
            return src.toInstant().atZone(TimeZone.getDefault().toZoneId()).toLocalDateTime();
        }
    }


    @Bean
    public DynamoDBMapper dynamoDbMapper(){
        return new DynamoDBMapper(amazonDynamoDB());
    }

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        AmazonDynamoDB dynamodb = AmazonDynamoDBClientBuilder.standard()
            .withCredentials(new InstanceProfileCredentialsProvider(false))
            .withRegion("ap-northeast-2")
            .build();
        return dynamodb;
    }
    /*
    @Bean
    public AmazonDynamoDB buildAmazonDynamoDB(){
        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(amazonEndpointConfiguration())
                .withCredentials(awsCredentialsProvider())
                .build();
    }

    private AwsClientBuilder.EndpointConfiguration amazonEndpointConfiguration(){
        return new AwsClientBuilder.EndpointConfiguration(amazonDynamoDbEndPoint, "ap-northeast-2");
    }


    @Bean
    public AWSCredentialsProvider awsCredentialsProvider(){
        return new AWSStaticCredentialsProvider(new BasicAWSCredentials(amazonDynamoDbAccessKey, amazonDynamoDbSecretKey));
    }


     */

}
