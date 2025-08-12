package me.parkjeounghyun.springbootdeveloper.config.error.exception;

import me.parkjeounghyun.springbootdeveloper.config.error.ErrorCode;

public class TokenUnauthorizedException extends UnauthorizedException {

    public TokenUnauthorizedException() {
        super(ErrorCode.TOKEN_UNAUTHORIZED);
    }

}
