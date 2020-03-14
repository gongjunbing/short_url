package com.gong.url.bo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * url业务对象
 *
 * @author gongjunbing
 * @date 2020/03/14 14:04
 **/
@Data
public class UrlBO {

    /**
     * 短码
     */
    private String shortKey;

    /**
     * 短网址
     */
    private String shortUrl;

    /**
     * 长网址
     */
    private String originUrl;

    /**
     * 失效时间
     */
    private LocalDateTime expireTime;

    /**
     * 是否删除
     */
    private Boolean isDelete;

}
