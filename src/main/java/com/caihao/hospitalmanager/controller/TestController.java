package com.caihao.hospitalmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 *
 * @Author 蔡浩
 * @Date 2019/4/4 15:56
 */
@Controller
public class TestController {
  // @CrossOrigin
  @RequestMapping("/test")
  @ResponseBody
  public String test(){
    return "test success";
  }

  @RequestMapping("/test2")
  public String test2(){
    return "/abc.html";
  }
}
