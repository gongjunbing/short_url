package com.gong.url.serice;

import com.gong.url.bo.UrlBO;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * url服务层
 *
 * @author gongjunbing
 * @date 2020/03/14 13:48
 **/
public interface UrlService {

    /**
     * 构造短链
     *
     * @param originUrl 长地址
     * @param expireDay 失效天数
     * @return UrlBO
     */
    UrlBO generic(String originUrl, int expireDay);

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
     *
     * @param shortKey 短码
     * @return UrlBO
     */
    UrlBO selectByShortKey(String shortKey);
    /**
     * 校验原地址是否已存在转换
     *
     * @param originUrl 原地址
     * @return UrlBO
     */
    UrlBO checkUrlIsExist(String originUrl);

    /**
     * 查询短链列表
     *
     * @return List<UrlBO>
     */
    List<UrlBO> list();

    /**
     * 分页查询短链列表
     *
     * @param pageIndex 页码
     * @param pageSize  页大小
     * @return List<UrlBO>
     */
    List<UrlBO> page(Integer pageIndex, Integer pageSize);
}
