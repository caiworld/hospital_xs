package com.caihao.hospitalmanager.service.impl;

import com.caihao.hospitalmanager.entity.User;
import com.caihao.hospitalmanager.entity.dto.UserDto;
import com.caihao.hospitalmanager.mapper.UserMapper;
import com.caihao.hospitalmanager.service.UserService;
import org.apache.shiro.crypto.hash.Md5Hash;
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

  /**
   * 修改密码
   *
   * @param userDto 用户、密码
   * @return int
   * @author 蔡浩
   * @date 2019/5/27 13:18
   * @since 1.0.0
   */
  @Override
  public int updatePwd(UserDto userDto) {
    // 密码没有跟着一起查，或者放到下面校验也行
    User user = userMapper.selectUserByUsername(userDto.getUsername());
    // 数据校验 TODO
    // 生成新密码
    String newPwd = new Md5Hash(userDto.getNewPwd(), user.getSalt(), 2).toString();
    // 修改密码
    return userMapper.updatePwdByUsername(userDto.getUsername(), newPwd);
  }
}
