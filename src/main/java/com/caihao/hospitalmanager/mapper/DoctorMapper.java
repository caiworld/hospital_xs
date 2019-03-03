package com.caihao.hospitalmanager.mapper;

import com.caihao.hospitalmanager.entity.Doctor;
import com.caihao.hospitalmanager.mapper.generator.MyMapper;

import java.util.List;

public interface DoctorMapper extends MyMapper<Doctor> {

  /**
   * 查询医生信息
   *
   * @return:java.util.List<com.caihao.hospitalmanager.entity.Doctor>
   * @author:蔡浩
   * @date: 2019/3/3 16:16
   * @since: 1.0.0
   */
  List<Doctor> selectDoctorList();
}