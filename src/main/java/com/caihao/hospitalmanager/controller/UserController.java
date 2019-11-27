package com.caihao.hospitalmanager.controller;

import com.caihao.hospitalmanager.entity.Result;
import com.caihao.hospitalmanager.entity.User;
import com.caihao.hospitalmanager.entity.dto.UserDto;
import com.caihao.hospitalmanager.service.UserService;
import com.caihao.hospitalmanager.shiro.UserRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author caihao
 * @date 2019/4/13 16:02
 */
@RestController
public class UserController {

  @Autowired
  private UserService userService;

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

  /**
   * 修改密码
   *
   * @param userDto 用户信息
   * @return com.caihao.hospitalmanager.entity.Result
   * @author 蔡浩
   * @date 2019/5/27 13:19
   * @since 1.0.0
   */
  @PostMapping("/update_pwd")
  public Result updatePwd(@RequestBody UserDto userDto) {
      userService.updatePwd(userDto);
    return new Result(Result.OK, "修改成功");
  }
}
