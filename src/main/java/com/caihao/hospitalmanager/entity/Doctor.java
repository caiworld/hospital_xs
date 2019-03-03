package com.caihao.hospitalmanager.entity;

import java.util.Date;

import javax.persistence.*;

/**
 * 医生实体类
 *
 * @Author 蔡浩
 * @Date 2019/2/26 20:07
 */
@Table(name = "`doctor`")
public class Doctor {
  /**
   * 主键，自增长
   */
  @Id
  @Column(name = "`id`")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /**
   * 姓名
   */
  @Column(name = "`name`")
  private String name;

  /**
   * 性别，0.男，1.女
   */
  @Column(name = "`sex`")
  private Boolean sex;

  /**
   * 头像
   */
  @Column(name = "`headImg`")
  private String headimg;

  /**
   * 职称
   */
  @Column(name = "`title`")
  private Integer title;

  /**
   * 职位
   */
  @Column(name = "`position`")
  private Integer position;

  /**
   * 部门
   */
  @Column(name = "`department`")
  private String department;

  /**
   * 出生时间
   */
  @Column(name = "`birth_time`")
  private Date birthTime;

  /**
   * 开始工作时间
   */
  @Column(name = "`work_time`")
  private Date workTime;

  /**
   * 获取主键，自增长
   *
   * @return id - 主键，自增长
   */
  public Integer getId() {
    return id;
  }

  /**
   * 设置主键，自增长
   *
   * @param id 主键，自增长
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * 获取姓名
   *
   * @return name - 姓名
   */
  public String getName() {
    return name;
  }

  /**
   * 设置姓名
   *
   * @param name 姓名
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * 获取性别，0.男，1.女
   *
   * @return sex - 性别，0.男，1.女
   */
  public Boolean getSex() {
    return sex;
  }

  /**
   * 设置性别，0.男，1.女
   *
   * @param sex 性别，0.男，1.女
   */
  public void setSex(Boolean sex) {
    this.sex = sex;
  }

  /**
   * 获取头像
   *
   * @return headImg - 头像
   */
  public String getHeadimg() {
    return headimg;
  }

  /**
   * 设置头像
   *
   * @param headimg 头像
   */
  public void setHeadimg(String headimg) {
    this.headimg = headimg;
  }

  /**
   * 获取职称
   *
   * @return title - 职称
   */
  public Integer getTitle() {
    return title;
  }

  /**
   * 设置职称
   *
   * @param title 职称
   */
  public void setTitle(Integer title) {
    this.title = title;
  }

  /**
   * 获取职位
   *
   * @return position - 职位
   */
  public Integer getPosition() {
    return position;
  }

  /**
   * 设置职位
   *
   * @param position 职位
   */
  public void setPosition(Integer position) {
    this.position = position;
  }

  /**
   * 获取部门
   *
   * @return department - 部门
   */
  public String getDepartment() {
    return department;
  }

  /**
   * 设置部门
   *
   * @param department 部门
   */
  public void setDepartment(String department) {
    this.department = department;
  }

  /**
   * 获取出生时间
   *
   * @return birth_time - 出生时间
   */
  public Date getBirthTime() {
    return birthTime;
  }

  /**
   * 设置出生时间
   *
   * @param birthTime 出生时间
   */
  public void setBirthTime(Date birthTime) {
    this.birthTime = birthTime;
  }

  /**
   * 获取开始工作时间
   *
   * @return work_time - 开始工作时间
   */
  public Date getWorkTime() {
    return workTime;
  }

  /**
   * 设置开始工作时间
   *
   * @param workTime 开始工作时间
   */
  public void setWorkTime(Date workTime) {
    this.workTime = workTime;
  }
}