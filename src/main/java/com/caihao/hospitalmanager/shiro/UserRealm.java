package com.caihao.hospitalmanager.shiro;

import com.caihao.hospitalmanager.entity.User;
import com.caihao.hospitalmanager.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author caihao
 * @date 2019/4/13 15:30
 */
public class UserRealm extends AuthorizingRealm {

  @Autowired
  private UserService userService;

  /**
   * 授权处理
   *
   * @param principals 权限集合
   * @return org.apache.shiro.authz.AuthorizationInfo
   * @author 蔡浩
   * @date 2019/4/13 15:32
   * @since 1.0.0
   */
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    // 这个方法获取的是认证处理里面认证信息的第一个参数
    User user = (User) principals.getPrimaryPrincipal();
    SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
    // 设置角色
    String[] roles = user.getRoles().split(",");
    Set<String> roleSet = new HashSet<>(Arrays.asList(roles));
    info.setRoles(roleSet);
    // 设置权限
    String[] perms = user.getPerms().split(",");
    Set<String> permSet = new HashSet<>(Arrays.asList(perms));
    info.setStringPermissions(permSet);
    return info;
  }

  /**
   * 认证处理
   *
   * @param authenticationToken 身份验证token
   * @return org.apache.shiro.authc.AuthenticationInfo
   * @author 蔡浩
   * @date 2019/4/13 15:33
   * @since 1.0.0
   */
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
    // 编写shiro判断逻辑，判断账号和密码
    UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
    // 1.判断账号
    String username = token.getUsername();
    User user = userService.getUserByUsername(username);
    if (Objects.isNull(user)) {
      // 账号错误，Shiro底层会抛出UnknownAccountException异常
      return null;
    }
    String salt = user.getSalt();
    // 2.判断密码
    SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), "");
    // 设置密盐
    info.setCredentialsSalt(ByteSource.Util.bytes(salt));
    return info;
  }
}
