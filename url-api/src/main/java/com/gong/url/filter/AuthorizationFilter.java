package com.gong.url.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * 授权过滤器
 *
 * @author gongjunbing
 * @date 2020/03/24 14:07
 **/
@Component
@WebFilter(filterName = "authorization", urlPatterns = "/*")
@Slf4j
@Order(2)
public class AuthorizationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("初始化：" + filterConfig.getFilterName());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        log.info("AuthorizationFilter对请求进行预处理");

        log.info("AuthorizationFilter请求预处理结束");

        // 执行拦截请求
        chain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        log.info("销毁过滤器AuthorizationFilter");
    }
}
