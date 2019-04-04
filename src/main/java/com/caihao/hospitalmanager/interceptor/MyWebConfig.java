package com.caihao.hospitalmanager.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
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
//    super.addInterceptors(registry);
  }

  /**
   * 允许跨域请求
   *
   * @param registry registry
   * @return void
   * @author 蔡浩
   * @date 2019/4/4 17:46
   * @since 1.0.0
   */
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
            .allowCredentials(true)
            .allowedHeaders("*")
            .allowedOrigins("*")
            .allowedMethods("*");
  }
}
