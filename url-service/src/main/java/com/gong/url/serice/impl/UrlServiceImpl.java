package com.gong.url.serice.impl;

import com.github.pagehelper.PageHelper;
import com.gong.url.Util;
import com.gong.url.bo.UrlBO;
import com.gong.url.entity.UrlDO;
import com.gong.url.mapper.UrlMapper;
import com.gong.url.serice.UrlService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gongjunbing
 * @date 2020/03/14 14:33
 **/
@Service
@AllArgsConstructor
public class UrlServiceImpl implements UrlService {

    private final UrlMapper urlMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UrlBO generic(String originUrl, int expireDay) {
        UrlDO urlDO = new UrlDO();
        urlDO.setCreateTime(LocalDateTime.now());
        urlDO.setOriginUrl(originUrl);
        urlDO.setIsDelete(true);
        int insertResult = urlMapper.insertSelective(urlDO);
        int id = urlDO.getId();

        // 短码
        String key = Util.convertToBase62(id);

        urlDO.setUpdateTime(LocalDateTime.now());
        urlDO.setExpireTime(LocalDateTime.now().plusDays(expireDay));
        urlDO.setShortKey(key);
        urlDO.setIsDelete(false);

//        if (key.length() > 0) {
//            throw new RuntimeException("this is a wrong!");
//        }
        int updateResult = urlMapper.updateByPrimaryKeySelective(urlDO);

        UrlBO urlBO = new UrlBO();
        BeanUtils.copyProperties(urlDO, urlBO);

        return urlBO;
    }

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

    @Override
    public UrlBO checkUrlIsExist(String originUrl) {

        UrlDO urlDO = urlMapper.checkUrlIsExist(originUrl);
        if (urlDO == null) {
            return null;
        }
        UrlBO urlBO = new UrlBO();
        BeanUtils.copyProperties(urlDO, urlBO);
        return urlBO;
    }

    @Override
    public List<UrlBO> list() {
        List<UrlDO> urlDOList = urlMapper.list();
        if (urlDOList == null || urlDOList.size() == 0) {
            return null;
        }
        return urlDOList.stream().map(c -> {
            UrlBO urlBO = new UrlBO();
            BeanUtils.copyProperties(c, urlBO);
            return urlBO;
        }).collect(Collectors.toList());
    }

    @Override
    public List<UrlBO> page(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<UrlDO> urlDOList = urlMapper.list();
        return urlDOList.stream().map(c -> {
            UrlBO urlBO = new UrlBO();
            BeanUtils.copyProperties(c, urlBO);
            return urlBO;
        }).collect(Collectors.toList());
    }

}
