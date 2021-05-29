package com.j2kb.jibapi.global.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.AbstractConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * Created by mkhwang on 2021/04/28
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${web.security.excludePathPatterns:}")
    private String[] excludePathPatterns;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")//TODO : 도메인 추가
                .allowedMethods(HttpMethod.GET.name()
                        , HttpMethod.PATCH.name()
                        , HttpMethod.PUT.name()
                        , HttpMethod.POST.name()
                        , HttpMethod.DELETE.name());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new InterceptorConfig()).addPathPatterns("/**");
                //.excludePathPatterns(excludePathPatterns)
                //TODO : 인터셉터 예외처리 패턴이 필요 하다면 excludePathPatterns 정의 후 주석 해제
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.removeIf( e -> e.getSupportedMediaTypes().contains(MediaType.APPLICATION_JSON));  // 기존 json용 컨버터 제거
        converters.add(new MappingJackson2HttpMessageConverter());  // 새로 json 컨버터 추가. 필요시 커스텀 컨버터 bean 사용
    }
}
