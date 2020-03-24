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
 * 鉴权过滤器
 *
 * @author gongjunbing
 * @date 2020/03/24 14:17
 **/
@Component
@Slf4j
@WebFilter(filterName = "authenticationFilter", urlPatterns = "/*")
@Order(1)
public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("初始化：" + filterConfig.getFilterName());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        log.info("AuthenticationFilter对请求进行预处理");

        try {
            Thread.sleep(1000 * 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("AuthenticationFilter请求预处理结束");

        // 执行拦截请求
        chain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        log.info("销毁过滤器AuthenticationFilter");
    }
}
