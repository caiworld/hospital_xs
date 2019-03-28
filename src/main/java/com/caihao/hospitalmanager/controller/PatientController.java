package com.caihao.hospitalmanager.controller;

import com.caihao.hospitalmanager.entity.Result;
import com.caihao.hospitalmanager.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 病人管理controller
 *
 * @Author 蔡浩
 * @Date 2019/3/14 18:37
 */
@RestController
@RequestMapping("/patient")
public class PatientController {

  @Autowired
  private PatientService patientService;

  /**
   * 获取病人信息
   *
   * @param pageNum 页数
   * @return com.caihao.hospitalmanager.entity.Result
   * @author 蔡浩
   * @date 2019/3/28 21:56
   * @since 1.0.0
   */
  @GetMapping("/get_patient_list")
  public Result getPatientList(@RequestParam(defaultValue = "1") Integer pageNum) {
    return new Result(Result.OK, patientService.getPatientList(pageNum));
  }
}
