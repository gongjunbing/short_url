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
    private final ErrorCode error;
    /**
     * 辅助数据
     */
    @Getter
    private final HashMap<String, Object> data = new HashMap<>();

    public BaseException(ErrorCode error, Map<String, Object> data) {
        super(error.getMessage());
        this.error = error;
        if (!ObjectUtils.isEmpty(data)) {
            this.data.putAll(data);
        }
    }

    protected BaseException(ErrorCode error, Map<String, Object> data, Throwable cause) {
        super(error.getMessage(), cause);
        this.error = error;
        if (!ObjectUtils.isEmpty(data)) {
            this.data.putAll(data);
        }
    }
}
