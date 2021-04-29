package com.j2kb.jibapi.global.error.exception;

/**
 * Created by mkhwang on 2021/04/28
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
public class InvalidValueException extends BusinessException {

    public InvalidValueException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public InvalidValueException(ErrorCode errorCode) {
        super(errorCode);
    }
}
