package com.j2kb.jibapi.domain.user.enums;

import com.j2kb.jibapi.global.util.enumMapper.EnumMapperType;

import java.util.Arrays;

/**
 * Created by mkhwang on 2021/07/03
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
public enum ServiceType implements EnumMapperType {

    WIFI("Wifi"),
    PARKING("Parking"),
    FOOD("Food"),
    RIDE("Ride");

    private String description;

    ServiceType(String description) {
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

    public static ServiceType findByCode(String name) {
        return Arrays.stream(ServiceType.values())
                .filter(value -> name.equals(value.getName()))
                .findAny()
                .orElse(null);
    }

}
