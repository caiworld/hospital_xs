package com.caihao.hospitalmanager.service.impl;

import com.caihao.hospitalmanager.Common;
import com.caihao.hospitalmanager.entity.Patient;
import com.caihao.hospitalmanager.mapper.PatientMapper;
import com.caihao.hospitalmanager.service.PatientService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 病人service的impl
 *
 * @author caihao
 * @date 2019/3/28 21:48
 */
@Service
public class PatientServiceImpl implements PatientService {
  @Autowired
  private PatientMapper patientMapper;

  /**
   * 获取所有病人信息
   *
   * @param pageNum 页数
   * @return java.util.List<com.caihao.hospitalmanager.entity.Patient>
   * @author 蔡浩
   * @date 2019/3/28 21:52
   * @since 1.0.0
   */
  @Override
  public PageInfo<Patient> getPatientList(Integer pageNum) {
    PageHelper.startPage(pageNum, Common.PAGESIZE);
    return new PageInfo<>(patientMapper.selectPatientList());
  }

  /**
   * 根据病人id获取病人信息
   *
   * @param id 病人id
   * @return com.caihao.hospitalmanager.entity.Patient
   * @author 蔡浩
   * @date 2019/4/12 14:26
   * @since 1.0.0
   */
  @Override
  public Patient getPatientById(Integer id) {
    return patientMapper.selectByPrimaryKey(id);
  }

  /**
   * 新增病人信息
   *
   * @param patient 病人信息
   * @return int
   * @author 蔡浩
   * @date 2019/4/12 14:29
   * @since 1.0.0
   */
  @Override
  public int savePatient(Patient patient) {
    return patientMapper.insertSelective(patient);
  }

  /**
   * 修改病人信息
   *
   * @param patient 病人信息
   * @return int
   * @author 蔡浩
   * @date 2019/4/12 14:29
   * @since 1.0.0
   */
  @Override
  public int updatePatient(Patient patient) {
    return patientMapper.updateByPrimaryKeySelective(patient);
  }

  /**
   * 根据病人id删除病人信息
   *
   * @param id 病人id
   * @return int
   * @author 蔡浩
   * @date 2019/4/12 14:32
   * @since 1.0.0
   */
  @Override
  public int deletePatientById(Integer id) {
    return patientMapper.deleteByPrimaryKey(id);
  }
}
