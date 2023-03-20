package com.liuche.wiki.config;

import com.liuche.wiki.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer { // 增加拦截器
    @Resource
    LoginInterceptor loginInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/test/**",
                        "/redis/**",
                        "/user/login",
                        "/category/all",
                        "/ebook/list",
                        "/doc/all/**",
                        "/doc/vote/**",
                        "/doc/get-one/**",
                        "/doc/get-one-doc/**",
                        "/doc/get-content/**",
                        "/ebook-snapshot/**",
                        "/category/list",
                        "/ebook/update",
                        "ebook-snapshot/get-statistic",
                        "ebook-snapshot/get-30-statistic",
                        "/favicon.ico"
                );

    }
}
