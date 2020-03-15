package com.gong.url.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常拦截
 *
 * @author gongjunbing
 * @date 2020/03/12 23:48
 **/
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 自定义异常处理
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

    /**
     * 参数验证失败异常处理
     *
     * @param ex      MethodArgumentNotValidException
     * @param request 请求
     * @return ResponseEntity<ErrorResponse>
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        String path = request.getRequestURI();
        Map<String, String> errors = new HashMap<>(16);
        ex.getBindingResult().getFieldErrors().forEach((error) -> {
            String fieldName = error.getField();
            String errorDefaultMessage = error.getDefaultMessage();
            if (!errors.containsKey(fieldName)) {
                errors.put(fieldName, errorDefaultMessage);
            }
        });

        log.debug("参数校验失败：" + errors.toString());
        ErrorResponse response = new ErrorResponse(new BadRequestException(errors), path);

        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    /**
     * 参数验证失败异常处理
     *
     * @param ex      ConstraintViolationException
     * @param request 请求
     * @return ResponseEntity<ErrorResponse>
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException ex, HttpServletRequest request) {
        String path = request.getRequestURI();
        Map<String, String> errors = new HashMap<>(16);
        String message = ex.getMessage();
        if (StringUtils.hasLength(message)) {
            String[] fields = message.split(":");
            if (fields.length > 1) {
                errors.put(fields[0].trim(), fields[1].trim());
            }
        }
        log.debug("参数校验失败：" + errors.toString());
        ErrorResponse response = new ErrorResponse(new BadRequestException(errors), path);
        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
