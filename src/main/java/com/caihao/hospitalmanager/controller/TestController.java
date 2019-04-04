package com.caihao.hospitalmanager.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 *
 * @Author 蔡浩
 * @Date 2019/4/4 15:56
 */
@RestController
public class TestController {
  @CrossOrigin
  @RequestMapping("/test")
  public String test(){
    return "test success";
  }
}
