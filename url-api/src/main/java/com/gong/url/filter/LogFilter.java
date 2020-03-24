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
 * 过滤器
 *
 * @author gongjunbing
 * @date 2020/03/24 10:03
 **/
@Component
@Slf4j
@WebFilter(filterName = "log", urlPatterns = "/*")
@Order(3)
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("初始化：" + filterConfig.getFilterName());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        log.info("LogFilter对请求进行预处理");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // 请求接口url
        String requestUri = request.getRequestURI();
        log.info("请求接口地址：" + requestUri);

        Instant startTime = Instant.now();
        // 执行拦截请求
        chain.doFilter(servletRequest, servletResponse);
        Instant endTime = Instant.now();
        long costTime = ChronoUnit.MILLIS.between(startTime, endTime);
        log.info("LogFilter请求预处理结束，耗时：" + costTime + "(ms)");
    }

    @Override
    public void destroy() {
        log.info("销毁过滤器LogFilter");
    }
}
