package com.gong.url.exception;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

/**
 * 错误码
 *
 * @author gongjunbing
 * @date 2020/03/12 23:34
 **/
@ToString
public enum ErrorCode {

    /**
     * 请求参数不合法
     */
    BAD_REQUEST(400, HttpStatus.BAD_REQUEST, "请求参数不合法");

    /**
     * 业务错误码
     */
    @Getter
    private final int code;
    /**
     * HTTP状态码
     */
    @Getter
    private final HttpStatus httpStatus;
    /**
     * 错误信息描述
     */
    @Getter
    private final String message;

    ErrorCode(int code, HttpStatus httpStatus, String message) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
