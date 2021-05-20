package com.j2kb.jibapi.domain.user.enums;

import com.j2kb.jibapi.global.util.enumMapper.EnumMapperType;
import java.util.Arrays;

public enum Preferences implements EnumMapperType {

    FOOD("Food"),
    RIDE_OFFER("Ride Offer"),
    PETS("Pets"),
    SMOKING("Smoking"),
    CLEAN("Clean"),
    NO_CURFEW("No Curfew"),
    QUICK_RESPONSE("Quick Response"),
    SECURITY("Security"),
    GROCERY_NEARBY("Grocery Nearby"),
    SUBWAY_NEARBY("Subway Nearby"),
    FREE_INTERNET("Free Internet"),
    KITCHEN("Kitchen");

    private String description;

    Preferences(String description){
        this.description = description;
    }

    @Override
    public String getName() {
        return name();
    }

    @Override
    public String getDescription() {
        return description;
    }

    public static Preferences findByCode(String name) {
        return Arrays.stream(Preferences.values())
                .filter(value -> name.equals(value.getName()))
                .findAny()
                .orElse(null);
    }

    @Override
    public String toString() {
        return name();
    }
}