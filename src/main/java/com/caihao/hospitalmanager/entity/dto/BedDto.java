package com.caihao.hospitalmanager.entity.dto;

import com.caihao.hospitalmanager.entity.Bed;

import lombok.Data;

/**
 * TODO
 *
 * @Author 蔡浩
 * @Date 2019/4/4 17:05
 */
@Data
public class BedDto extends Bed {
  /**
   * 病人名字
   */
  private String patientName;
  /**
   * 病床等级名称
   */
  private String bedGradeName;
  /**
   * 花费
   */
  private Double cost;
}
