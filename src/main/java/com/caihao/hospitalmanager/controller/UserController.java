package com.caihao.hospitalmanager.controller;

import com.caihao.hospitalmanager.entity.Result;
import com.caihao.hospitalmanager.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caihao
 * @date 2019/4/13 16:02
 */
@RestController
public class UserController {

  /**
   * 登陆
   *
   * @param user 用户
   * @return com.caihao.hospitalmanager.entity.Result
   * @author 蔡浩
   * @date 2019/4/13 16:41
   * @since 1.0.0
   */
  @PostMapping("/login")
  public Result login(@RequestBody User user) {
    // 使用shiro编写认证主体
    // 1.获取subject主体
    Subject subject = SecurityUtils.getSubject();
    // 2.封装用户数据
    UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
    try {
      // 3.执行登陆
      subject.login(token);
    } catch (UnknownAccountException e) {
      return new Result(Result.ERROR, "账号错误");
    } catch (IncorrectCredentialsException e) {
      return new Result(Result.ERROR, "密码错误");
    }
    return new Result(Result.OK, "登陆成功");
  }

  /**
   * 退出登陆
   *
   * @return com.caihao.hospitalmanager.entity.Result
   * @author 蔡浩
   * @date 2019/4/13 16:41
   * @since 1.0.0
   */
  @GetMapping("/logout")
  public Result logout() {
    Subject subject = SecurityUtils.getSubject();
    subject.logout();
    return new Result(Result.OK, "退出成功");
  }
}
