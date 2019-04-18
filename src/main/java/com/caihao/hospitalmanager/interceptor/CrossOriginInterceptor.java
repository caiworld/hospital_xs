package com.caihao.hospitalmanager.interceptor;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 允许跨域拦截器
 *
 * @Author 蔡浩
 * @Date 2019/4/4 16:13
 */
public class CrossOriginInterceptor implements HandlerInterceptor {
  /**
   * 在请求处理之前进行调用（Controller方法调用之前)
   *
   * @author 蔡浩
   * @date 2019/4/4 16:16
   * @since 1.0.0
   */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object
          handler) throws Exception {
    // 设置允许跨域
    response.setHeader("Access-Control-Allow-Origin", "*");
    response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, " +
            "Accept");
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object
          handler, ModelAndView modelAndView) throws Exception {

  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object
          handler, Exception ex) throws Exception {

  }
}
