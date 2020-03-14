package com.gong.url.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

/**
 * url表数据对象
 *
 * @author gongjunbing
 */
@Data
public class UrlDO implements Serializable {
    private Integer id;

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
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 最后更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 失效时间
     */
    private LocalDateTime expireTime;

    /**
     * 是否删除
     */
    private Boolean isDelete;

    private static final long serialVersionUID = 1L;
}