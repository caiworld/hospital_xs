package com.caihao.hospitalmanager.interceptor;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author caihao
 * @date 2019/4/22 21:38
 */
//@Component
public class CORSFilter implements Filter {
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    System.out.println("设置跨域Init");
  }

  @Override
  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
    HttpServletResponse response = (HttpServletResponse)resp;
    HttpServletRequest request = (HttpServletRequest) req;
    System.out.println(request.getHeader("Access-Control-Request-Method"));
    if( request.getHeader("Access-Control-Request-Method") != null && request.getHeader("Access-Control-Request-Headers") != null ){
      response.setHeader("Access-Control-Allow-Origin","http://localhost:9696");
      response.setHeader("Access-Control-Allow-Methods",request.getHeader("Access-Control-Request-Method"));
      response.setHeader("Access-Control-Allow-Headers",request.getHeader("Access-Control-Request-Headers"));
      response.setHeader("Access-Control-Max-Age","300");
      response.setHeader("Access-Control-Allow-Credentials","true");
    }
    filterChain.doFilter(request,response);
  }
  @Override
  public void destroy() {
    System.out.println("设置跨域destroy");
  }
}

