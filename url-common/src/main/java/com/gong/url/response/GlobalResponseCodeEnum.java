package com.gong.url.response;

import lombok.Getter;
import lombok.ToString;

/**
 * 全局返回状态码枚举
 *
 * @author gongjunbing
 * @date 2020/03/17 14:19
 **/
@ToString
public enum GlobalResponseCodeEnum {
    /**
     * 成功
     */
    OK(200, "成功"),

    /**
     * 请求参数不合法
     */
    BAD_REQUEST(400, "请求参数不合法"),

    /**
     * 未鉴权
     */
    UNAUTHORIZED(401, "未鉴权"),

    /**
     * 无权限
     */
    FORBIDDEN(403, "无权限"),

    /**
     * 未找到资源或资源不存在
     */
    NOT_FOUND(404, "未找到资源或资源不存在"),

    /**
     * 系统异常，程序猿正在抢救……
     */
    INTERNAL_SERVER_ERROR(500, "系统异常，程序猿正在抢救……");

    @Getter
    private final int code;

    @Getter
    private final String message;

    private GlobalResponseCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
