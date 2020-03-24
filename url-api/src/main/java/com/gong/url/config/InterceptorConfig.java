package com.gong.url.config;

import com.gong.url.interceptor.AuthenticationInterceptor;
import com.gong.url.interceptor.AuthorizationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 *
 * @author gongjunbing
 * @date 2020/03/24 22:38
 **/
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthenticationInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new AuthorizationInterceptor()).addPathPatterns("/**");
    }
}
