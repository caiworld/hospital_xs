package com.caihao.hospitalmanager.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * 编辑病床的dto
 *
 * @author caihao
 * @date 2019/4/22 11:31
 */
@Data
public class BedEditDto {
  /**
   * 病床编号
   */
  private Integer id;
  /**
   * 病床等级
   */
  private Integer grade;
  /**
   * 病床等级集合
   */
  private List<DropDownDto> bedGradeList;
}
