package me.parkjeounghyun.springbootdeveloper.config.error.exception;

import me.parkjeounghyun.springbootdeveloper.config.error.ErrorCode;

public class UserUnauthorizedException extends UnauthorizedException {

    public UserUnauthorizedException() {
        super(ErrorCode.USER_UNAUTHORIZED);
    }

}
