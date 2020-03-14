package com.gong.url.serice.impl;

import com.gong.url.bo.UrlBO;
import com.gong.url.entity.UrlDO;
import com.gong.url.mapper.UrlMapper;
import com.gong.url.serice.UrlService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author gongjunbing
 * @date 2020/03/14 14:33
 **/
@Service
@AllArgsConstructor
public class UrlServiceImpl implements UrlService {

    private final UrlMapper urlMapper;

    @Override
    public int insertUrl(UrlBO url) {
        UrlDO urlDO = new UrlDO();
        BeanUtils.copyProperties(url, urlDO);
        urlDO.setCreateTime(LocalDateTime.now());
        urlDO.setIsDelete(true);
        int command = urlMapper.insertSelective(urlDO);
        int id = urlDO.getId();
        return id;
    }

    @Override
    public int updateUrl(int id, UrlBO url) {
        UrlDO urlDO = new UrlDO();
        BeanUtils.copyProperties(url, urlDO);
        urlDO.setId(id);
        urlDO.setUpdateTime(LocalDateTime.now());
        urlDO.setIsDelete(false);
        return urlMapper.updateByPrimaryKeySelective(urlDO);
    }

    @Override
    public UrlBO selectByShortKey(String shortKey) {

        UrlDO urlDO = urlMapper.selectByShortKey(shortKey);
        if (urlDO == null) {
            return null;
        }
        UrlBO urlBO = new UrlBO();
        BeanUtils.copyProperties(urlDO, urlBO);

        return urlBO;
    }
}
