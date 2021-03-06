package com.j2kb.jibapi.global.common;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * Created by mkhwang on 2021/04/28
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
@Data
public class SuccessResponse {
    private int status;
    private String message;
    private Object payload;

    public SuccessResponse(int status, String message, Object payload) {
        this.status = status;
        this.message = message;
        this.payload = payload;
    }

    public SuccessResponse(int value, String reasonPhrase) {
        this(value, reasonPhrase, null);
    }

    public static SuccessResponse success(Object payload) {
        return new SuccessResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), payload);
    }

    public static SuccessResponse success() {
        return new SuccessResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }
}
