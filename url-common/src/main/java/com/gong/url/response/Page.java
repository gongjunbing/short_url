package com.gong.url.response;

import com.github.pagehelper.PageInfo;
import lombok.Getter;
import lombok.ToString;

import java.util.Collection;
import java.util.List;

/**
 * 分页返回对象
 *
 * @author gongjunbing
 * @date 2020/03/17 14:37
 **/
@ToString
public class Page<T> {

    /**
     * 页索引，当前页
     */
    @Getter
    private Integer pageIndex;
    /**
     * 每页大小
     */
    @Getter
    private Integer pageSize;
    /**
     * 总数
     */
    @Getter
    private Long totalNum;
    /**
     * 总页数
     */
    @Getter
    private Long totalPageNum;
    /**
     * 数据源
     */
    @Getter
    private List<T> list;

    public Page(Integer pageIndex, Integer pageSize, Long totalNum, List<T> list) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.totalNum = totalNum;
        this.totalPageNum = (totalNum - 1) / pageSize + 1;
        this.list = list;
    }

    public Page(List<T> list) {
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        this.pageIndex = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.totalNum = pageInfo.getTotal();
        this.totalPageNum = (long) pageInfo.getPages();
        this.list = list;
    }


}
