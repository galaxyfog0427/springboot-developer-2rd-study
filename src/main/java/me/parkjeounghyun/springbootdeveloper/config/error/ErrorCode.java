package me.parkjeounghyun.springbootdeveloper.config.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "ER1", "올바르지 않은 입력값입니다."),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "ER2", "잘못된 HTTP 메서드를 호출했습니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "ER3", "서버 에러가 발생했습니다."),

    NOT_FOUND(HttpStatus.NOT_FOUND, "NF0", "엔티티를 찾을 수 없습니다."),
    ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND, "NF1", "게시글을 찾을 수 없습니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "NF2", "사용자를 찾을 수 없습니다."),

    NOT_AUTHORIZED(HttpStatus.FORBIDDEN, "UA0", "인증 또는 권한이 필요합니다."),
    TOKEN_UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "UA1", "유효하지 않은 토큰입니다."),
    USER_UNAUTHORIZED(HttpStatus.FORBIDDEN, "UA2", "해당 리소스에 접근할 수 없습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;

    ErrorCode(final HttpStatus status, final String code, final String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
