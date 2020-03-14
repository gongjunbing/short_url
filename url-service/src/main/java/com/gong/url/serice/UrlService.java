package com.gong.url.serice;

import com.gong.url.bo.UrlBO;

/**
 * url服务层
 *
 * @author gongjunbing
 * @date 2020/03/14 13:48
 **/
public interface UrlService {

    /**
     * 新增
     *
     * @param url UrlBO
     * @return int
     */
    int insertUrl(UrlBO url);

    /**
     * 根据id更新
     *
     * @param id  id
     * @param url UrlBO
     * @return int
     */
    int updateUrl(int id, UrlBO url);

    /**
     * 根据短码查询
     * @param shortKey 短码
     * @return UrlBO
     */
    UrlBO selectByShortKey(String shortKey);
}
