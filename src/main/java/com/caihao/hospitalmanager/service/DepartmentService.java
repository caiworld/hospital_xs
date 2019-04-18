package com.caihao.hospitalmanager.service;

import com.caihao.hospitalmanager.entity.dto.DropDownDto;

import java.util.List;

/**
 * @author caihao
 * @date 2019/4/18 13:38
 */
public interface DepartmentService {

  /**
   * 获取科室下拉框集合
   *
   * @return java.util.List<com.caihao.hospitalmanager.entity.dto.DropDownDto>
   * @author 蔡浩
   * @date 2019/4/18 13:40
   * @since 1.0.0
   */
  List<DropDownDto> getDepartmentList();
}
