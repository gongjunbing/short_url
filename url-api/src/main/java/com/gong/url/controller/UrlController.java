package com.gong.url.controller;

import com.gong.url.exception.BadRequestException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * Url控制器
 *
 * @author gongjunbing
 * @date 2020/03/12 23:07
 **/
@RestController
@RequestMapping("/api/url")
public class UrlController {

    @PostMapping("/generic")
    public String generic(@RequestBody String url) {
        if (!StringUtils.isEmpty(url)) {
            throw new BadRequestException(null);
        }
        return "ok";
    }
}
