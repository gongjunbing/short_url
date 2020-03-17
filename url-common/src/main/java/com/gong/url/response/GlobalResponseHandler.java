package com.gong.url.response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 全局返回处理器
 *
 * @author gongjunbing
 * @date 2020/03/17 15:05
 **/
@Slf4j
@ControllerAdvice(annotations = {RestController.class, Controller.class})
public class GlobalResponseHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        final String returnTypeName = returnType.getParameterType().getName();

        log.debug("returnTypeName = " + returnTypeName);
        return !GlobalResponseConstants.VOID.equals(returnTypeName)
                && !GlobalResponseConstants.GLOBAL_RESPONSE_CLASSNAME.equals(returnTypeName)
                && !GlobalResponseConstants.SPRING_RESPONSE_ENTITY_CLASSNAME.equals(returnTypeName);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        final String returnTypeName = returnType.getParameterType().getName();
        // 返回类型不是JSON类型
        if (!selectedContentType.includes(MediaType.APPLICATION_JSON)) {
            return body;
        }

        return GlobalResponse.success(body);
    }
}
