package com.caihao.hospitalmanager.mapper;

import com.caihao.hospitalmanager.entity.Patient;
import com.caihao.hospitalmanager.mapper.generator.MyMapper;

import java.util.List;

public interface PatientMapper extends MyMapper<Patient> {
  /**
   * 查询所有病人信息
   *
   * @return java.util.List<com.caihao.hospitalmanager.entity.Patient>
   * @author 蔡浩
   * @date 2019/3/28 22:02
   * @since 1.0.0
   */
  List<Patient> selectPatientList();
}