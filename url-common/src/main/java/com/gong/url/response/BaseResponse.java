package com.gong.url.response;

import lombok.Getter;

/**
 * 全局返回基类
 *
 * @author gongjunbing
 * @date 2020/03/17 14:39
 **/
public abstract class BaseResponse {
    /**
     * 状态码
     */
    @Getter
    protected int code;
    /**
     * 描述
     */
    @Getter
    protected String message;
    /**
     * 时间戳（毫秒）
     */
    @Getter
    protected long timeStamp;

    public BaseResponse(int code, String message) {
        this.code = code;
        this.message = message;
        this.timeStamp = System.currentTimeMillis();
    }
}
