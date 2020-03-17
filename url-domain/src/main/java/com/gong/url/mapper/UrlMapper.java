package com.gong.url.mapper;

import com.gong.url.entity.UrlDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * url表操作接口
 *
 * @author gongjunbing
 */
@Mapper
public interface UrlMapper {
    /**
     * 根据主键删除
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增
     *
     * @param record UrlDO对象
     * @return 主键
     */
    int insert(UrlDO record);

    /**
     * 动态新增列
     *
     * @param record UrlDO对象
     * @return 主键
     */
    int insertSelective(UrlDO record);

    /**
     * 查询短链列表
     *
     * @return UrlDO
     */
    List<UrlDO> list();

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return UrlDO对象
     */
    UrlDO selectByPrimaryKey(Integer id);

    /**
     * 根据短码查询
     *
     * @param shortKey 短码
     * @return UrlDO对象
     */
    UrlDO selectByShortKey(String shortKey);

    /**
     * 校验原地址是否已存在转换
     *
     * @param originUrl 原地址
     * @return UrlDO对象
     */
    UrlDO checkUrlIsExist(String originUrl);

    /**
     * 根据主键更新动态列
     *
     * @param record Url
     * @return 影响行数
     */
    int updateByPrimaryKeySelective(UrlDO record);

    /**
     * 根据主键更新
     *
     * @param record UrlDO
     * @return 影响行数
     */
    int updateByPrimaryKey(UrlDO record);
}