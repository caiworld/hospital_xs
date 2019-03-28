package com.caihao.hospitalmanager.service;

import com.caihao.hospitalmanager.entity.Patient;
import com.github.pagehelper.PageInfo;

/**
 * 病人service
 *
 * @author caihao
 * @date 2019/3/28 21:47
 */
public interface PatientService {

  /**
   * 获取所有病人信息
   *
   * @param pageNum 页数
   * @return java.util.List<com.caihao.hospitalmanager.entity.Patient>
   * @author 蔡浩
   * @date 2019/3/28 21:52
   * @since 1.0.0
   */
  PageInfo<Patient> getPatientList(Integer pageNum);
}
