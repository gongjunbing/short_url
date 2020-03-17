package com.gong.url.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

/**
 * 分页请求
 *
 * @author gongjunbing
 * @date 2020/03/17 22:06
 **/
@Data
public class PageRequest {

    /**
     * 页码
     */
    @Range(min = 1, max = 99999)
    @ApiModelProperty(value = "页码", required = true, example = "1")
    private Integer pageIndex;

    /**
     * 页大小
     */
    @Range(min = 1, max = 200)
    @ApiModelProperty(value = "页大小", required = true, example = "10")
    private Integer pageSize;
}
