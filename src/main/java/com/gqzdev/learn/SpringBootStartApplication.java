package com.gqzdev.learn;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/**
 * @ClassName SpringBootStartApplication
 * @Description  通过外部的Tomcat启动
 * @Author ganquanzhong
 * @Date2021/4/11 19:21
 * @Version
 **/
public class SpringBootStartApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

        // 注意这里要指向原先用main方法执行的Application启动类 
        return builder.sources(LearnApplication.class);
    }
}
