package com.gong.url.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 鉴权拦截器
 *
 * @author gongjunbing
 * @date 2020/03/24 22:11
 **/
@Slf4j
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    /**
     * 请求到达控制器之前执行
     *
     * @param request  request
     * @param response response
     * @param handler  handler
     * @return true：请求继续向下执行。false：请求终止
     * @throws Exception 异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("拦截器 AuthenticationInterceptor.preHandle");

        return super.preHandle(request, response, handler);
    }

    /**
     * 请求经过控制器处理之后但尚未返回结果
     *
     * @param request      request
     * @param response     response
     * @param handler      handler
     * @param modelAndView modelAndView
     * @throws Exception Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        log.info("拦截器 AuthenticationInterceptor.postHandle");

        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        log.info("拦截器 AuthenticationInterceptor.afterCompletion");

        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("拦截器 AuthenticationInterceptor.afterConcurrentHandlingStarted");

        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
