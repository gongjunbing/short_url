package com.gong.url.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.gong.url.Util;
import com.gong.url.bo.UrlBO;
import com.gong.url.dto.UrlDTO;
import com.gong.url.request.AddUrlRequest;
import com.gong.url.request.QueryUrlRequest;
import com.gong.url.response.Page;
import com.gong.url.serice.UrlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Url控制器
 *
 * @author gongjunbing
 * @date 2020/03/12 23:07
 **/
@RestController
@AllArgsConstructor
@Api(tags = "短链接接口")
@RequestMapping("/url")
@Validated
public class UrlController {

    private UrlService urlService;

    @ApiOperationSupport(author = "tiansheng9527@gmail.com")
    @ApiOperation("生成短链接")
    @PostMapping("/generic")
    public UrlDTO generic(@RequestBody @Valid AddUrlRequest request) {

        UrlBO urlBO = urlService.checkUrlIsExist(request.getOriginUrl());
        if (urlBO == null) {
            urlBO = urlService.generic(request.getOriginUrl(), 7);
        }

        UrlDTO response = new UrlDTO();
        BeanUtils.copyProperties(urlBO, response);

        return response;
    }

    @ApiOperationSupport(author = "tiansheng9527@gmail.com")
    @ApiOperation("查询短链列表")
    @PostMapping("/list")
    public List<UrlDTO> list() {

        List<UrlBO> urlBOList = urlService.list();
        List<UrlDTO> urlDTOList = urlBOList.stream().map(c -> {
            UrlDTO urlDTO = new UrlDTO();
            BeanUtils.copyProperties(c, urlDTO);
            return urlDTO;
        }).collect(Collectors.toList());

        return urlDTOList;
    }

    @ApiOperationSupport(author = "tiansheng9527@gmail.com")
    @ApiOperation("分页查询短链列表")
    @PostMapping("/page")
    public Page<UrlBO> page(@Valid @RequestBody QueryUrlRequest request) {

        List<UrlBO> urlBOList = urlService.page(request.getPageIndex(), request.getPageSize());
        Page<UrlBO> pageResult = new Page<UrlBO>(urlBOList);

        return pageResult;
    }

//    @ApiOperationSupport(author = "tiansheng9527@gmail.com")
//    @ApiOperation("生成短链接")
//    @PostMapping("/genericForm")
//    @ApiImplicitParams(@ApiImplicitParam(name = "originUrl", paramType = "query"))
//    public ResponseEntity<UrlDTO> genericForm(@Valid @NotBlank @URL @RequestParam("originUrl") String originUrl) {
//        UrlBO urlBO = new UrlBO();
//        urlBO.setOriginUrl(originUrl);
//
//        int id = urlService.insertUrl(urlBO);
//
//        String key = Util.convertToBase62(id);
//
//        urlBO.setExpireTime(LocalDateTime.now().plusDays(7));
//        urlBO.setIsDelete(false);
//        urlBO.setShortKey(key);
//        int result = urlService.updateUrl(id, urlBO);
//
//        UrlDTO response = new UrlDTO();
//        BeanUtils.copyProperties(urlBO, response);
//
//        return ResponseEntity.ok(response);
//    }

    @GetMapping("/u/{key}")
    public void redirect(@PathVariable("key") @Valid String key, HttpServletResponse response) {
        if (StringUtils.isEmpty(key)) {
            return;
        }

        UrlBO urlBO = urlService.selectByShortKey(key);
        if (urlBO == null) {
            return;
        }
        if (urlBO.getIsDelete()) {
            return;
        }
        if (urlBO.getExpireTime().compareTo(LocalDateTime.now()) < 0) {
            return;
        }
        String originUrl = urlBO.getOriginUrl();
        if (StringUtils.isEmpty(originUrl)) {
            return;
        }
        try {
            response.sendRedirect(originUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
