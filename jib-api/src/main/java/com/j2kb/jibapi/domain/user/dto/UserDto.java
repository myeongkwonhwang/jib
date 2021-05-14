package com.j2kb.jibapi.domain.user.dto;

import com.j2kb.jibapi.global.util.enumMapper.EnumMapperType;
import lombok.Getter;

public class UserDto {

    @Getter
    public enum UserType {
        STUDENT("AB01", "student"),
        PARENT("AB02", "parent"),
        WORKER("AB03", "worker"),
        HOST("AB04", "host");

        private String code;
        private String description;

        UserType(String code, String description) {
            this.code = code;
            this.description = description;
        }
    }

    public enum DistancePreference {
        TEN("AC01", "10"),
        TWENTY("AC02", "20"),
        THIRTY("AC03", "30"),
        ANY("AC04", "Doesn't Matter");

        private String code;
        private String description;

        DistancePreference(String code, String description) {
            this.code = code;
            this.description = description;
        }
    }

    @Getter
    public enum HouseType {
        ENTIRE("AD01", "entireHouse"),
        SHARED("AD02", "sharedHouse"),
        PRIVATE("AD03", "privateHouse"),
        NO_PREFERNCE("AD04", "noPreference");

        private String code;
        private String description;

        HouseType(String code, String description) {
            this.code = code;
            this.description = description;
        }
    }

    public enum Preferences implements EnumMapperType {

        FOOD("AF01","Food"),
        RIDE_OFFER("AF02","Ride Offer"),
        PETS("AF03","Pets"),
        SMOKING("AF04","Smoking"),
        CLEAN("AF05","Clean"),
        NO_CURFEW("AF06","No Curfew"),
        QUICK_RESPONSE("AF07","Quick Response"),
        SECURITY("AF08","Security"),
        GROCERY_NEARBY("AF09","Grocery Nearby"),
        SUBWAY_NEARBY("AF10","Subway Nearby"),
        FREE_INTERNET("AF11","Free Internet"),
        KITCHEN("AF12","Kitchen");

        private String code;
        private String description;

        Preferences(String code, String description){
            this.code = code;
            this.description = description;
        }

        @Override
        public String getName() {
            return name();
        }

        @Override
        public String getTitle() {
            return description;
        }
    }
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
        };


        */