package com.gong.url.exception;

import lombok.Getter;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 错误基类
 *
 * @author gongjunbing
 * @date 2020/03/12 23:36
 **/
public abstract class BaseException extends RuntimeException {

    /**
     * 错误码
     */
    @Getter
    private final ErrorCodeEnum error;
    /**
     * 辅助数据
     */
    @Getter
    private final Map<String, String> data = new HashMap<>();

    public BaseException(ErrorCodeEnum error, Map<String, String> data) {
        super(error.getMessage());
        this.error = error;
        if (!ObjectUtils.isEmpty(data)) {
            this.data.putAll(data);
        }
    }

    protected BaseException(ErrorCodeEnum error, Map<String, String> data, Throwable cause) {
        super(error.getMessage(), cause);
        this.error = error;
        if (!ObjectUtils.isEmpty(data)) {
            this.data.putAll(data);
        }
    }
}
