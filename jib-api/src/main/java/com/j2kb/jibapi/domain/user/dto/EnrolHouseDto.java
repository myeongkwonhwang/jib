package com.j2kb.jibapi.domain.user.dto;

import com.j2kb.jibapi.domain.user.enums.CommonAreaType;
import com.j2kb.jibapi.domain.user.enums.FurnitureType;
import com.j2kb.jibapi.domain.user.enums.ServiceType;
import lombok.Data;
import java.util.List;

public class EnrolHouseDto {

    @Data
    public static class EnrolReq{
        private HomeInfo homeInfo;
    }

    @Data
    public static class HomeInfo {
        private Location location;
        private HomeDescription homeDescription;
        private List<String> keyword;
        private String occupablePeriod;
        private Integer minimumRequiredStay;
        private Cost cost;
        private HomeValidation homeValidation;
    }
    @Data
    public static class Location {
        private String country;
        private String province;
        private String city;
        private String homeAddress;
        private String detailAddress;
        private String zipCode;
        private String lat;
        private String lng;

        public com.j2kb.jibapi.domain.host.entity.Location toEntity(){
            return com.j2kb.jibapi.domain.host.entity.Location.builder()
            .country(country)
            .province(province)
            .city(city)
            .detailAddress(detailAddress)
            .homeAddress(homeAddress)
            .zipCode(zipCode)
            .lat(lat)
            .lng(lng)
            .build();
        }
    }

    @Data
    public static class HomeDescription {
        private String homeType;
        private Offer offer;
        //private List<MultipartFile> homePictures;
        private String homeTitle;
        private List<String> nearbyFacilities;
        private List<String> homePolicy;
        private List<String> extraInfo;
    }

    @Data
    public static class Offer {
        private List<FurnitureType> furniture;
        private List<ServiceType> service;
        private List<CommonAreaType> commonArea;
    }

    @Data
    public static class Cost {
        private String monetaryUnit;
        private Integer baseRate;
        private Integer deposit;
        private Integer administrativeExpenses;
        private Integer foodExpenses;
    }

    @Data
    public static class HomeValidation {
        private Boolean isValidate;
        private List<String> documents;
    }

}
