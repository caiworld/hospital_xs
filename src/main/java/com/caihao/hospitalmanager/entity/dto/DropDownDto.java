package com.caihao.hospitalmanager.entity.dto;

import lombok.Data;

/**
 * 下拉框dto
 * @author caihao
 * @date 2019/4/18 13:35
 */
@Data
public class DropDownDto {
  /**
   * 对应id
   */
  private Integer value;
  /**
   * 对应名称
   */
  private String label;
}
