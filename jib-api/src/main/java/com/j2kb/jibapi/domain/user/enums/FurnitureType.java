package com.j2kb.jibapi.domain.user.enums;

import com.j2kb.jibapi.global.util.enumMapper.EnumMapperType;

import java.util.Arrays;

/**
 * Created by mkhwang on 2021/07/03
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
public enum FurnitureType implements EnumMapperType {
    DESK("Desk"),
    BED("Bed"),
    LAUNDRY("Laundray"),
    DRYER("Dryer"),
    REFRIGERATOR("Refrigrator"),
    HEATER("Heater"),
    AIRCONDITIONING("Airconditioning"),
    TV("TV");

    private String description;

    FurnitureType(String description) {
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

    public static FurnitureType findByCode(String name) {
        return Arrays.stream(FurnitureType.values())
                .filter(value -> name.equals(value.getName()))
                .findAny()
                .orElse(null);
    }
}
