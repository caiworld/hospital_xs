package com.caihao.hospitalmanager.service;

import com.caihao.hospitalmanager.entity.Patient;
import com.caihao.hospitalmanager.entity.dto.PatientDto;
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
  PageInfo<PatientDto> getPatientList(Integer pageNum);

  /**
   * 根据病人id获取病人信息
   *
   * @param id 病人id
   * @return com.caihao.hospitalmanager.entity.Patient
   * @author 蔡浩
   * @date 2019/4/12 14:26
   * @since 1.0.0
   */
  Patient getPatientById(Integer id);

  /**
   * 新增病人信息
   *
   * @param patient 病人信息
   * @return int
   * @author 蔡浩
   * @date 2019/4/12 14:29
   * @since 1.0.0
   */
  int savePatient(Patient patient);

  /**
   * 修改病人信息
   *
   * @param patient 病人信息
   * @return int
   * @author 蔡浩
   * @date 2019/4/12 14:29
   * @since 1.0.0
   */
  int updatePatient(Patient patient);

  /**
   * 根据病人id删除病人信息
   *
   * @param id 病人id
   * @return int
   * @author 蔡浩
   * @date 2019/4/12 14:32
   * @since 1.0.0
   */
  int deletePatientById(Integer id);
}
