package com.caihao.hospitalmanager.mapper;

import com.caihao.hospitalmanager.entity.Doctor;
import com.caihao.hospitalmanager.entity.dto.DoctorDto;
import com.caihao.hospitalmanager.generator.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DoctorMapper extends MyMapper<Doctor> {

  /**
   * 查询医生信息
   *
   * @param name         姓名
   * @param departmentId 科室id
   * @return:java.util.List<com.caihao.hospitalmanager.entity.Doctor>
   * @author:蔡浩
   * @date: 2019/3/3 16:16
   * @since: 1.0.0
   */
  List<DoctorDto> selectDoctorList(@Param("name") String name, @Param("departmentId") Integer departmentId);
}