package com.gqzdev.learn.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @ClassName WebMvcConfig
 * @Description
 * @Author ganquanzhong
 * @Date2021/4/11 16:43
 * @Version
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Resource
    private MyInterceptor myInterceptor;

    @Resource
    private VerifyCodeServlet verifyCodeServlet;
    /**
     *  设置url匹配模式
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        //setUseSuffixPatternMatch设置是否是后缀模式匹配
        //setUseTrailingSlashMatch设置是否自动后缀路径模式匹配
        configurer.setUseSuffixPatternMatch(true)
                .setUseTrailingSlashMatch(true);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/META-INF/resources/")
                .addResourceLocations("classpath:/resources/")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/static/**")
                .addResourceLocations("classpath:/static/*")
                .addResourceLocations("classpath:/public/");
    }

    /**
     * 实现自定义拦截器只需要3步
     * 1、创建我们自己的拦截器类并实现 HandlerInterceptor 接口。
     * 2、创建一个Java类继承WebMvcConfigurerAdapter，并重写 addInterceptors 方法。
     * 3、实例化我们自定义的拦截器，然后将对像手动添加到拦截器链中（在addInterceptors方法中添加）。
     */

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor).addPathPatterns("/**");
    }


    /**
     *  注册servlet
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        return  new ServletRegistrationBean(verifyCodeServlet,"/VerifyCode");
    }
}
