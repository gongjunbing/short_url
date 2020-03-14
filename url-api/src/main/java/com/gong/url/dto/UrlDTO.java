package com.gong.url.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * url数据传输对象
 *
 * @author gongjunbing
 * @date 2020/03/14 15:13
 **/
@Data
@ApiModel("响应报文")
public class UrlDTO {
    /**
     * 长网址
     */
    @ApiModelProperty("原地址")
    private String originUrl;

    /**
     * 短码
     */
    @ApiModelProperty("原地址")
    private String shortKey;

    /**
     * 失效时间
     */
    @ApiModelProperty("原地址")
    private LocalDateTime expireTime;
}
