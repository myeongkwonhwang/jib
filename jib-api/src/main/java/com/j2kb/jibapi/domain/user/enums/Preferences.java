package com.j2kb.jibapi.domain.user.enums;

import com.j2kb.jibapi.global.util.enumMapper.EnumMapperType;
import java.util.Arrays;

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
    public String getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public static Preferences findByCode(String code) {
        return Arrays.stream(Preferences.values())
                .filter(value -> value.getCode().equals(code))
                .findAny()
                .orElse(null);
    }

    @Override
    public String toString() {
        return name();
    }
}