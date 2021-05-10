package com.j2kb.jibapi.domain.destination.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * Created by mkhwang on 2021/05/08
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
public class DestinationDto {

    @Getter
    @Setter
    @ToString
    @Builder
    public static class SaveReq {

        @NotNull
        @ApiModelProperty("목적지 이름")
        private String name;

        @NotNull
        @ApiModelProperty("나라")
        private String country;

        @ApiModelProperty("도/시/군")
        private String province;

        @ApiModelProperty("시")
        private String city;

        @NotNull
        @ApiModelProperty("우편번호")
        private String zipCode;

        @ApiModelProperty("경도")
        private Double latitude;

        @ApiModelProperty("위도")
        private Double longitude;

        public SaveReq() {
        }

        public SaveReq(String name, String country, String province, String city, String zipCode, Double latitude, Double longitude) {
            this.name = name;
            this.country = country;
            this.province = province;
            this.city = city;
            this.zipCode = zipCode;
            this.latitude = latitude;
            this.longitude = longitude;
        }
    }

    @Getter
    @Setter
    @ToString
    @Builder
    public static class SaveRes {

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

        public SaveRes() {
        }

        public SaveRes(Long dstNo, String name, String country, String province, String city, String zipCode, Double latitude, Double longitude) {
            this.dstNo = dstNo;
            this.name = name;
            this.country = country;
            this.province = province;
            this.city = city;
            this.zipCode = zipCode;
            this.latitude = latitude;
            this.longitude = longitude;
        }
    }
}
