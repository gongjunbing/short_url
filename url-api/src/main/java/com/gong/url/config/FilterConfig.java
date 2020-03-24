//package com.gong.url.config;
//
//import com.gong.url.filter.AuthenticationFilter;
//import com.gong.url.filter.AuthorizationFilter;
//import com.gong.url.filter.LogFilter;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * 过滤器配置类
// *
// * @author gongjunbing
// * @date 2020/03/24 14:27
// **/
//@Configuration
//@Slf4j
//@RequiredArgsConstructor
//public class FilterConfig {
//    private final LogFilter logFilter;
//    private final AuthenticationFilter authenticationFilter;
//    private final AuthorizationFilter authorizationFilter;
//
//    @Bean
//    public FilterRegistrationBean<LogFilter> logFilterFilterRegister() {
//        FilterRegistrationBean result = new FilterRegistrationBean(logFilter);
//        result.setName("logFilter");
//        result.setOrder(3);
//        result.addUrlPatterns("/*");
//
//        return result;
//    }
//
//    @Bean
//    public FilterRegistrationBean<AuthenticationFilter> authenticationFilterRegister() {
//        FilterRegistrationBean result = new FilterRegistrationBean(authenticationFilter);
//        result.setName("authenticationFilter");
//        result.setOrder(1);
//        result.addUrlPatterns("/*");
//
//        return result;
//    }
//
//    @Bean
//    public FilterRegistrationBean<AuthorizationFilter> authorizationFilterRegister() {
//        FilterRegistrationBean result = new FilterRegistrationBean(authorizationFilter);
//        result.setName("authorizationFilter");
//        result.setOrder(2);
//        result.addUrlPatterns("/*");
//
//        return result;
//    }
//}
