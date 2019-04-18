package com.caihao.hospitalmanager.entity.dto;

import com.caihao.hospitalmanager.entity.Doctor;

import lombok.Data;

/**
 * 医生类的扩展dto
 *
 * @Author 蔡浩
 * @Date 2019/3/7 18:32
 */
@Data
public class DoctorDto extends Doctor {
  /**
   * 职位名称
   */
  private String positionName;
  /**
   * 职称名称
   */
  private String titleName;
  /**
   * 部门名称
   */
  private String departmentName;
}
