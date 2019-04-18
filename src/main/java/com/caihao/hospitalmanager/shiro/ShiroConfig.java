package com.caihao.hospitalmanager.shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro配置类
 *
 * @author caihao
 * @date 2019/4/13 15:30
 */
@Configuration
public class ShiroConfig {

  /**
   * 1.创建UserRealm
   *
   * @return com.caihao.hospitalmanager.shiro.UserRealm
   * @author 蔡浩
   * @date 2019/4/13 15:35
   * @since 1.0.0
   */
  @Bean
  public UserRealm getUserRealm() {
    return new UserRealm();
  }

  /**
   * 设置加密
   *
   * @return org.apache.shiro.authc.credential.HashedCredentialsMatcher
   * @author 蔡浩
   * @date 2019/4/13 17:03
   * @since 1.0.0
   */
  @Bean
  public HashedCredentialsMatcher getHashedCredentialsMatcher() {
    HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
    // 设置加密方式
    hashedCredentialsMatcher.setHashAlgorithmName("md5");
    // 设置加密次数
    hashedCredentialsMatcher.setHashIterations(2);
    return hashedCredentialsMatcher;
  }

  /**
   * 创建安全管理器
   *
   * @param userRealm UserRealm
   * @return org.apache.shiro.web.mgt.DefaultWebSecurityManager
   * @author 蔡浩
   * @date 2019/4/13 15:37
   * @since 1.0.0
   */
  @Bean
  public DefaultWebSecurityManager getSecurityManager(UserRealm userRealm, HashedCredentialsMatcher hashedCredentialsMatcher) {
    DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    // 设置加密
    userRealm.setCredentialsMatcher(hashedCredentialsMatcher);
    // 关联realm
    securityManager.setRealm(userRealm);
    return securityManager;
  }

  /**
   * 创建ShiroFilterFactoryBean
   *
   * @param securityManager 安全管理器
   * @return org.apache.shiro.spring.web.ShiroFilterFactoryBean
   * @author 蔡浩
   * @date 2019/4/13 15:43
   * @since 1.0.0
   */
  @Bean
  public ShiroFilterFactoryBean getShiroFilterFactoryBean(SecurityManager securityManager) {
    ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
    // 设置安全管理器
    shiroFilterFactoryBean.setSecurityManager(securityManager);
    // 设置没登陆时跳转到的登陆页面
    // shiroFilterFactoryBean.setLoginUrl("http://www.baidu.com");
    shiroFilterFactoryBean.setLoginUrl("http://localhost:9696/#/passport/login");
    /*
     * Shiro内置过滤器：实现权限相关的拦截
     *      常用过滤器：
     *          anon（认证用）：无需认证（登录）即可访问
     *          authc（认证用）：必须认证才可访问
     *          user（少用）：使用rememberMe功能可以访问
     *          perms（授权用）：必须得到资源权限才可访问
     *          role（授权用）：必须得到角色权限才可访问
     */
    Map<String, String> filterMap = new LinkedHashMap<>();
    // 放行登陆请求
    filterMap.put("/login", "anon");
    // 放行测试请求
    filterMap.put("/test", "anon");
    // 配置退出过滤器，退出代码shiro已经实现
    filterMap.put("/logout", "anon");
    // 过滤链定义，从上向下顺序执行，一般将/*放在最下边
    filterMap.put("/**", "authc");
    shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
    return shiroFilterFactoryBean;
  }

  /**
   * 描述：开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
   * 配置以下两个bean(DefaultAdvisorAutoProxyCreator和AuthorizationAttributeSourceAdvisor)即可实现此功能
   * </br>Enable Shiro Annotations for Spring-configured beans. Only run after the
   * lifecycleBeanProcessor(保证实现了Shiro内部lifecycle函数的bean执行) has run </br>不使用注解的话，可以注释掉这两个配置
   *
   * @param securityManager securityManager
   * @return org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor
   * @author 蔡浩
   * @date 2019/2/26 13:04
   * @since 1.0.0
   */
  @Bean
  public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager
                                                                                         securityManager) {
    System.out.println("开启了Shiro注解支持(2/2)");
    AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new
            AuthorizationAttributeSourceAdvisor();
    authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
    return authorizationAttributeSourceAdvisor;
  }

  @Bean
  @ConditionalOnMissingBean
  public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
    System.out.println("开启了Shiro注解支持(1/2)");
    DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
    defaultAAP.setProxyTargetClass(true);
    return defaultAAP;
  }
}
