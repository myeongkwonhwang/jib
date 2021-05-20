package com.j2kb.jibapi.global.util.enumMapper;

/**
 * Created by mkhwang on 2021/05/14
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
public class EnumMapperValue {

    private String name;
    private String description;

    public EnumMapperValue(EnumMapperType enumMapperType) {
        this.name = enumMapperType.getName();
        this.description = enumMapperType.getDescription();
    }

    public String getName() {
        return name;
    }

    public String getDescription() { return description; }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
