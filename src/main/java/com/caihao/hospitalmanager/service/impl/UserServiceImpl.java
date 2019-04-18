package com.caihao.hospitalmanager.service.impl;

import com.caihao.hospitalmanager.entity.User;
import com.caihao.hospitalmanager.mapper.UserMapper;
import com.caihao.hospitalmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author caihao
 * @date 2019/4/13 16:03
 */
@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserMapper userMapper;

  /**
   * 通过用户名获取用户信息
   *
   * @param username 用户名
   * @return com.caihao.hospitalmanager.entity.User
   * @author 蔡浩
   * @date 2019/4/13 16:04
   * @since 1.0.0
   */
  @Override
  public User getUserByUsername(String username) {
    return userMapper.selectUserByUsername(username);
  }
}
