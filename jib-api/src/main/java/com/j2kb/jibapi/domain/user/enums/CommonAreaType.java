package com.j2kb.jibapi.domain.user.enums;

import com.j2kb.jibapi.global.util.enumMapper.EnumMapperType;
import lombok.Getter;

import java.util.Arrays;

/**
 * Created by mkhwang on 2021/07/03
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@Getter
public enum CommonAreaType implements EnumMapperType {

    POOL("Pool"),
    FITNESS("Fitness"),
    EVENTROOM("EventRoom"),
    STUDYROOM("StudyRoom");

    private String description;

    CommonAreaType(String description) {
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

    public static CommonAreaType findByCode(String name) {
        return Arrays.stream(CommonAreaType.values())
                .filter(value -> name.equals(value.getName()))
                .findAny()
                .orElse(null);
    }
}
