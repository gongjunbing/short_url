package com.gong.url.exception;

import com.gong.url.response.BaseResponse;
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
public class ErrorResponse extends BaseResponse {
    /**
     * 请求接口地址
     */
    @Getter
    private String path;

    /**
     * 错误说明辅助数据
     */
    @Getter
    private Map<String, String> data = new HashMap<>();


    public ErrorResponse(BaseException ex, String path) {
        this(ex.getError().getCode(), ex.getMessage(), path, ex.getData());
    }

    public ErrorResponse(int code, String message, String path, Map<String, String> data) {
        super(code, message);
        this.path = path;
        this.timeStamp = System.currentTimeMillis();
        if (!ObjectUtils.isEmpty(data)) {
            this.data.putAll(data);
        }
    }
}
