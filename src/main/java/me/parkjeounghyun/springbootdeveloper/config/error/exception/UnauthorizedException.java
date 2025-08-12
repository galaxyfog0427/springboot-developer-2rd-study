package me.parkjeounghyun.springbootdeveloper.config.error.exception;

import me.parkjeounghyun.springbootdeveloper.config.error.ErrorCode;

public class UnauthorizedException extends BusinessBaseException {

    public UnauthorizedException(ErrorCode errorCode) {
        super(errorCode.getMessage(), errorCode);
    }

    public UnauthorizedException() {
        super(ErrorCode.NOT_AUTHORIZED);
    }
}
