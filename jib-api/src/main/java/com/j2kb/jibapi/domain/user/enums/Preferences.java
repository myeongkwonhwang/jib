package com.j2kb.jibapi.domain.user.enums;

import com.j2kb.jibapi.global.util.enumMapper.EnumMapperType;

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