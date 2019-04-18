package com.caihao.hospitalmanager.service.impl;

import com.caihao.hospitalmanager.entity.dto.DropDownDto;
import com.caihao.hospitalmanager.mapper.DepartmentMapper;
import com.caihao.hospitalmanager.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author caihao
 * @date 2019/4/18 13:38
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

  @Autowired
  private DepartmentMapper departmentMapper;

  /**
   * 获取科室下拉框集合
   *
   * @return java.util.List<com.caihao.hospitalmanager.entity.dto.DropDownDto>
   * @author 蔡浩
   * @date 2019/4/18 13:40
   * @since 1.0.0
   */
  @Override
  public List<DropDownDto> getDepartmentList() {
    return departmentMapper.selectDropDownList();
  }
}
