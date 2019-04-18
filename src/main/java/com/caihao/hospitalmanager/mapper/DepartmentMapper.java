package com.caihao.hospitalmanager.mapper;

import com.caihao.hospitalmanager.entity.Department;
import com.caihao.hospitalmanager.entity.dto.DropDownDto;
import com.caihao.hospitalmanager.generator.MyMapper;

import java.util.List;

public interface DepartmentMapper extends MyMapper<Department> {

  /**
   * 获取科室下拉框集合
   *
   * @return java.util.List<com.caihao.hospitalmanager.entity.dto.DropDownDto>
   * @author 蔡浩
   * @date 2019/4/18 13:40
   * @since 1.0.0
   */
  List<DropDownDto> selectDropDownList();
}