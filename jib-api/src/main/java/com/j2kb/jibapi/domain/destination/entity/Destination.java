package com.j2kb.jibapi.domain.destination.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by mkhwang on 2021/05/08
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@Entity
@Table(name = "destination")
@DynamicInsert
@DynamicUpdate
@ApiModel(value = "destination", description = "목적지") //swagger
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("목적지 고유번호") //swagger
    private Long dstNo;

    @ApiModelProperty("목적지 이름")
    private String name;

    @ApiModelProperty("나라")
    private String country;

    @ApiModelProperty("도/시/군")
    private String province;

    @ApiModelProperty("시")
    private String city;

    @ApiModelProperty("우편번호")
    private String zipCode;

    @ApiModelProperty("경도")
    private Double latitude;

    @ApiModelProperty("위도")
    private Double longitude;

    /*private Timestamp createdAt;

    private Timestamp updatedAt;*/
}
/*

const Student = {
            id: `Unique String, SHA16`,
            personalInfo: {
            firstName: `String, VARCHAR=20`,
            lastName: `String, VARCHAR=20`,
            age: `Int, 3`,
            language: `String, VARCHAR`,
            email: `String, VARCHAR`,
            password: `String`,
            phoneNum: `String, VARCHAR optional`,
            profileImg: "URL",
},
targetDestionation: {
    school: `String, VARCHAR=30`, /// Request the location from the google map or mapbox api to get the location data
    country: `String, `, // Country Code
    province: `String, `,
    zipCode: `String, VARCHAR`,
    lat: `Int`,
    lng: `Int`,
},
        validateID: {
        isPhotoIDProvided: `Boolean, optional default = false`,
        isAccepted: `Boolean, default = false`,
        },
        mustHave: {
        rideDistanceFromSchool: `10 mins or 20 mins or 30 mins`,
        houseStyle: `entire house, private room, shared room, shared house`,
        host: ["#meal", "#ride", "#religion: Christian", "#wifi", "#pet"],
        },
        };*/
