package com.caihao.hospitalmanager.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 配置类
 *
 * @Author 蔡浩
 * @Date 2019/4/4 16:24
 */
@Configuration
public class MyWebConfig extends WebMvcConfigurerAdapter {
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
//    registry.addInterceptor(new CrossOriginInterceptor()).addPathPatterns("/**");
  }
}
