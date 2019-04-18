package com.caihao.hospitalmanager.mapper;

import com.caihao.hospitalmanager.entity.User;
import com.caihao.hospitalmanager.generator.MyMapper;

public interface UserMapper extends MyMapper<User> {

  /**
   * 通过用户名查询用户
   *
   * @param username 用户名
   * @return com.caihao.hospitalmanager.entity.User
   * @author 蔡浩
   * @date 2019/4/13 16:05
   * @since 1.0.0
   */
  User selectUserByUsername(String username);
}