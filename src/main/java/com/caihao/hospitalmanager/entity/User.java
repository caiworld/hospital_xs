package com.caihao.hospitalmanager.entity;

import javax.persistence.*;

@Table(name = "`user`")
public class User {
    /**
     * 主键id
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户名
     */
    @Column(name = "`username`")
    private String username;

    /**
     * 密码
     */
    @Column(name = "`password`")
    private String password;

    /**
     * 密盐
     */
    @Column(name = "`salt`")
    private String salt;

    /**
     * 角色
     */
    @Column(name = "`roles`")
    private String roles;

    /**
     * 权限
     */
    @Column(name = "`perms`")
    private String perms;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取密盐
     *
     * @return salt - 密盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置密盐
     *
     * @param salt 密盐
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取角色
     *
     * @return roles - 角色
     */
    public String getRoles() {
        return roles;
    }

    /**
     * 设置角色
     *
     * @param roles 角色
     */
    public void setRoles(String roles) {
        this.roles = roles;
    }

    /**
     * 获取权限
     *
     * @return perms - 权限
     */
    public String getPerms() {
        return perms;
    }

    /**
     * 设置权限
     *
     * @param perms 权限
     */
    public void setPerms(String perms) {
        this.perms = perms;
    }
}