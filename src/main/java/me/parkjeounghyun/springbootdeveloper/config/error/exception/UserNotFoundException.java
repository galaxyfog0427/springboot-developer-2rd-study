package me.parkjeounghyun.springbootdeveloper.config.error.exception;

import me.parkjeounghyun.springbootdeveloper.config.error.ErrorCode;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
