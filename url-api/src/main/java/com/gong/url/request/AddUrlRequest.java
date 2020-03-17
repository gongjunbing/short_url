package com.gong.url.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;

/**
 * url接口请求对象
 *
 * @author gongjunbing
 * @date 2020/03/14 15:36
 **/
@Data
public class AddUrlRequest {
    /**
     * 长网址
     */
    @NotBlank(message = "originUrl 不能为空")
    @Length(min = 1, max = 2083)
    @URL(message = "originUrl 必须是URL地址格式")
    @ApiModelProperty(value = "长网址", required = true)
    private String originUrl;
}
