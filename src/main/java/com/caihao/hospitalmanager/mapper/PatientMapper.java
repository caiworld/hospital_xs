package com.caihao.hospitalmanager.mapper;

import com.caihao.hospitalmanager.entity.Patient;
import com.caihao.hospitalmanager.entity.dto.PatientDto;
import com.caihao.hospitalmanager.generator.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PatientMapper extends MyMapper<Patient> {
  /**
   * 查询所有病人信息
   *
   * @param name         姓名
   * @param departmentId 科室id
   * @return java.util.List<com.caihao.hospitalmanager.entity.Patient>
   * @author 蔡浩
   * @date 2019/3/28 22:02
   * @since 1.0.0
   */
  List<PatientDto> selectPatientList(@Param("name") String name, @Param("departmentId") Integer departmentId);
}