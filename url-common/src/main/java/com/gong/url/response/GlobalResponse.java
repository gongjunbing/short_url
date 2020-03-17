package com.gong.url.response;

import lombok.Getter;
import lombok.ToString;

/**
 * 全局返回对象
 *
 * @author gongjunbing
 * @date 2020/03/17 14:13
 **/
@ToString
public class GlobalResponse<T> extends BaseResponse {
    @Getter
    private T data;

    public GlobalResponse(int code, String message, T data) {
        super(code, message);
        this.data = data;
    }

    public static <T> GlobalResponse<T> fail(int code, String message) {
        return new GlobalResponse<>(code, message, null);
    }

    public static <T> GlobalResponse<T> success(T data) {
        return new GlobalResponse<>(GlobalResponseCodeEnum.OK.getCode(), GlobalResponseCodeEnum.OK.getMessage(), data);
    }
}
