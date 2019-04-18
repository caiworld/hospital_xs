package com.caihao.hospitalmanager.controller;

import com.caihao.hospitalmanager.entity.Result;
import com.caihao.hospitalmanager.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 下拉框controller
 *
 * @author caihao
 * @date 2019/4/18 13:35
 */
@RestController
public class DropDownController {

  @Autowired
  private DepartmentService departmentService;

  /**
   * 获取科室下拉框信息
   *
   * @return com.caihao.hospitalmanager.entity.Result
   * @author 蔡浩
   * @date 2019/4/18 13:39
   * @since 1.0.0
   */
  @GetMapping("/get_department_list")
  public Result getDepartmentList() {
    return new Result(Result.OK, departmentService.getDepartmentList());
  }
}
