package com.j2kb.jibapi.global.common;

import lombok.Builder;
import org.springframework.http.HttpStatus;

/**
 * Created by mkhwang on 2021/04/28
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@Builder
public class Response {
    private int status;
    private String message;
    private Object obj;

    public Response(int status, String message, Object obj) {
        this.status = status;
        this.message = message;
        this.obj = obj;
    }

    public static Response success(Object obj) {
        return new Response(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), obj);
    }

    public static Response failed(int status, String message) {
        return new Response(status, message, null);
    }
}
