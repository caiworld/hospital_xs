package com.caihao.hospitalmanager.controller;

import com.caihao.hospitalmanager.entity.Result;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

  @GetMapping("/get_patient_list")
  public Result getPatientList(){
    return null;
  }
}
