package com.caihao.hospitalmanager.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * TODO
 *
 * @author caihao
 * @date 2019/4/22 16:32
 */
// @Configuration
public class CrossConfig {
  private CorsConfiguration buildConfig() {
    CorsConfiguration corsConfiguration = new CorsConfiguration();
    corsConfiguration.addAllowedOrigin("*"); // 允许任何域名使用
    corsConfiguration.addAllowedHeader("*"); // 允许任何头
    corsConfiguration.addAllowedMethod("*"); // 允许任何方法（post、get等）
    System.out.println("设置允许跨域1");
    return corsConfiguration;
  }

  @Bean
  public CorsFilter corsFilter() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", buildConfig()); // 对接口配置跨域设置
    return new CorsFilter(source);
  }
}
