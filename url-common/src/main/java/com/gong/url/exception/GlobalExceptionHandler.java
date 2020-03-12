package com.gong.url.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常拦截
 *
 * @author gongjunbing
 * @date 2020/03/12 23:48
 **/
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 异常处理
     *
     * @param ex      自定义异常
     * @param request 请求
     * @return ResponseEntity<ErrorResponse>
     */
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handleException(BaseException ex, HttpServletRequest request) {
        String path = request.getRequestURI();
        ErrorResponse response = new ErrorResponse(ex, path);

        return new ResponseEntity<>(response, new HttpHeaders(), ex.getError().getHttpStatus());
    }
}
