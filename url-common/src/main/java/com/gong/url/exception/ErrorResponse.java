package com.gong.url.exception;

import lombok.Getter;
import lombok.ToString;
import org.springframework.util.ObjectUtils;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * 错误返回包装
 *
 * @author gongjunbing
 * @date 2020/03/12 23:36
 **/
@ToString
public class ErrorResponse {

    /**
     * 业务错误码
     */
    @Getter
    private int code;
    /**
     * HTTP状态码
     */
    @Getter
    private int httpStatus;
    /**
     * 错误信息描述
     */
    @Getter
    private String message;
    /**
     * 请求接口地址
     */
    @Getter
    private String path;
    /**
     * 时间戳
     */
    @Getter
    private Instant timeStamp;
    /**
     * 错误说明辅助数据
     */
    @Getter
    private Map<String, String> data = new HashMap<>();


    public ErrorResponse(BaseException ex, String path) {
        this(ex.getError().getCode(), ex.getError().getHttpStatus().value(), ex.getMessage(), path, ex.getData());
    }

    public ErrorResponse(int code, int httpStatus, String message, String path, Map<String, String> data) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
        this.path = path;
        this.timeStamp = Instant.now();
        if (!ObjectUtils.isEmpty(data)) {
            this.data.putAll(data);
        }
    }
}
