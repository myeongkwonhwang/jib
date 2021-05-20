package com.j2kb.jibapi.global.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.j2kb.jibapi.domain.user.enums.*;
import com.j2kb.jibapi.global.util.enumMapper.EnumMapper;
import com.j2kb.jibapi.global.util.enumMapper.EnumMapperType;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NamingConventions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by mkhwang on 2021/04/28
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@Configuration
public class ApplicationConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ObjectMapper objectMapper() { return new ObjectMapper(); }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true).setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE) //private 필드 매칭
                .setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR) //이름이 규칙에 맞는것만 setter 필요.
                .setMatchingStrategy(MatchingStrategies.STRICT); //Source, Destination 의 property가 완전히 똑같아야 매핑된다.
        modelMapper.addConverter(codeEnumToStringConverter());
        return modelMapper;
    }

    /*
    * Dto => Entity : model mapper 변환 가능:
    * Entity(String code) => Dto(Enum ) : Entity나 Dto 에 변환하는 메서드를 정의를 해서 (modelMapper)
    * 회원 가입: 클라이언트에서 넘겨준 값을 Entity로 서버가 변환을 해서 Db
    * 내 회원 정보를 가져온다: 디비 Entity => Dto (String name => enum) :
    * 메서드: model mapper
    */
    public Converter<EnumMapperType, String> codeEnumToStringConverter() {
        return new AbstractConverter<>() {
            @Override
            protected String convert(EnumMapperType enumMapperType) {
                return enumMapperType.getName();
            }
        };
    }

    @Bean
    public EnumMapper enumMapper() {
        EnumMapper enumMapper = new EnumMapper();
        enumMapper.put("DistancePreference", DistancePreference.class);
        enumMapper.put("HouseType", HouseType.class);
        enumMapper.put("LoginType", LoginType.class);
        enumMapper.put("Preferences", Preferences.class);
        enumMapper.put("UserType", UserType.class);
        return enumMapper;
    }
}
