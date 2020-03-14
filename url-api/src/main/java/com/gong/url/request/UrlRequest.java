package com.gong.url.request;

import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * url接口请求对象
 *
 * @author gongjunbing
 * @date 2020/03/14 15:36
 **/
@Data
public class UrlRequest {
    /**
     * 长网址
     */
    @NotNull(message = "originUrl 不能为空")
    @Length(min = 1, max = 2083)
    @ApiModelProperty(value = "长网址", required = true)
    private String originUrl;
}
