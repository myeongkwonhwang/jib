package com.j2kb.jibapi.domain.user.enums;

import com.j2kb.jibapi.global.util.enumMapper.EnumMapperType;

import java.util.Arrays;

/**
 * Created by mkhwang on 2021/05/22
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
public enum StateType implements EnumMapperType {

    ACTIVE("active"),
    DELETED("deleted"),
    INACTIVE("inactive");

    private String description;

    StateType(String description) {
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

    public static StateType findByCode(String name) {
        return Arrays.stream(StateType.values())
                .filter(value -> name.equals(value.getName()))
                .findAny()
                .orElse(null);
    }
}
