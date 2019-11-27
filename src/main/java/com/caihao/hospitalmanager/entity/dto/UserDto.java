package com.caihao.hospitalmanager.entity.dto;

import com.caihao.hospitalmanager.entity.User;
import lombok.Data;

/**
 * TODO
 *
 * @author caihao
 * @date 2019/5/27 13:14
 */
@Data
public class UserDto {

  /**
   * 用户名
   */
  private String username;
  /**
   * 旧密码
   */
  private String oldPwd;
  /**
   * 新密码
   */
  private String newPwd;
  /**
   * 确认密码
   */
  private String confirmNewPwd;

}
