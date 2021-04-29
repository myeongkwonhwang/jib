package com.j2kb.jibapi.global.common;

import lombok.Builder;
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
    private Object obj;

    public SuccessResponse(int status, String message, Object obj) {
        this.status = status;
        this.message = message;
        this.obj = obj;
    }

    public static SuccessResponse success(Object obj) {
        return new SuccessResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), obj);
    }
}
