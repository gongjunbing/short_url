package com.gong.url.exception;

import java.util.Map;

/**
 * 请求参数不合法异常
 *
 * @author gongjunbing
 * @date 2020/03/12 23:46
 **/
public class BadRequestException extends BaseException {

    public BadRequestException(Map<String, Object> data) {
        super(ErrorCode.BAD_REQUEST, data);
    }
}
