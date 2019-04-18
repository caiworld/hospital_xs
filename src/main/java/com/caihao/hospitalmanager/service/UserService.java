package com.caihao.hospitalmanager.service;

import com.caihao.hospitalmanager.entity.User;

/**
 * @author caihao
 * @date 2019/4/13 16:03
 */
public interface UserService {

  /**
   * 通过用户名获取用户信息
   *
   * @param username 用户名
   * @return com.caihao.hospitalmanager.entity.User
   * @author 蔡浩
   * @date 2019/4/13 16:04
   * @since 1.0.0
   */
  User getUserByUsername(String username);
}
