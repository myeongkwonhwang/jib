package com.j2kb.jibapi.global.util.enumMapper;

/**
 * Created by mkhwang on 2021/05/14
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
public class EnumMapperValue {

    String name;
    String title;

    public EnumMapperValue(EnumMapperType enumMapperType) {
        name = enumMapperType.getName();
        title = enumMapperType.getTitle();
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "{" +
                 "code : " + name + "\'" +
                 "description : " + title + "\'" +
                "}";
    }
}
