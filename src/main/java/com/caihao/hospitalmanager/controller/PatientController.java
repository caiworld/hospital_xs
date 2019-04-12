package com.caihao.hospitalmanager.controller;

import com.caihao.hospitalmanager.entity.Patient;
import com.caihao.hospitalmanager.entity.Result;
import com.caihao.hospitalmanager.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

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
  @GetMapping("/get_list")
  public Result getPatientList(@RequestParam(defaultValue = "1") Integer pageNum) {
    return new Result(Result.OK, patientService.getPatientList(pageNum));
  }

  /**
   * 编辑病人信息
   *
   * @param id 病人id
   * @return com.caihao.hospitalmanager.entity.Result
   * @author 蔡浩
   * @date 2019/4/12 14:24
   * @since 1.0.0
   */
  @GetMapping("/edit")
  public Result editPatient(Integer id){
    return new Result(Result.OK, patientService.getPatientById(id));
  }

  /**
   * 保存病人信息
   *
   * @param patient 病人信息
   * @return com.caihao.hospitalmanager.entity.Result
   * @author 蔡浩
   * @date 2019/4/12 14:27
   * @since 1.0.0
   */
  @GetMapping("/save")
  public Result savePatient(Patient patient){
    if (Objects.isNull(patient.getId())){
      // 保存病人
      return new Result(Result.OK, patientService.savePatient(patient));
    }else {
      // 修改病人
      return new Result(Result.OK, patientService.updatePatient(patient));
    }
  }

  /**
   * 根据病人id删除病人信息
   *
   * @param id 病人id
   * @return com.caihao.hospitalmanager.entity.Result
   * @author 蔡浩
   * @date 2019/4/12 14:31
   * @since 1.0.0
   */
  @GetMapping("/delete")
  public Result deletePatient(Integer id){
    return new Result(Result.OK, patientService.deletePatientById(id));
  }
}
