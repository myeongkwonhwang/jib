package com.j2kb.jibapi.global.error.exception;

import com.j2kb.jibapi.domain.user.enums.TokenType;

public class InvalidTokenException extends BusinessException {

    public InvalidTokenException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public InvalidTokenException(String message) {
        super(message, ErrorCode.UNAUTHORIZED);
    }

    public InvalidTokenException(TokenType tokenType) {
        super(tokenType.getDescription() + " is not valid.", ErrorCode.UNAUTHORIZED);
    }

    public InvalidTokenException(ErrorCode errorCode) {
        super(errorCode);
    }
}
