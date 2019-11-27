package com.caihao.hospitalmanager.mapper;

import com.caihao.hospitalmanager.entity.Patient;
import com.caihao.hospitalmanager.entity.dto.DataDto;
import com.caihao.hospitalmanager.entity.dto.PatientDto;
import com.caihao.hospitalmanager.generator.MyMapper;
import java.util.Date;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PatientMapper extends MyMapper<Patient> {

  /**
   * 查询所有病人信息
   *
   * @param name 姓名
   * @param departmentId 科室id
   * @return java.util.List<com.caihao.hospitalmanager.entity.Patient>
   * @author 蔡浩
   * @date 2019/3/28 22:02
   * @since 1.0.0
   */
  List<PatientDto> selectPatientList(@Param("name") String name,
      @Param("departmentId") Integer departmentId);

  /**
   * 查询看病人数数据
   *
   * @param beginTime 开始时间
   * @param endTime 结束时间
   * @return java.util.List<com.caihao.hospitalmanager.entity.dto.DataDto>
   * @author 蔡浩
   * @date 2019/4/27 17:09
   * @since 1.0.0
   */
  List<DataDto> selectDiseaseData(@Param("beginTime") Date beginTime,
      @Param("endTime") Date endTime);

  /**
   * 查询住院人数数据
   *
   * @param beginTime 开始时间
   * @param endTime 结束时间
   * @return java.util.List<com.caihao.hospitalmanager.entity.dto.DataDto>
   * @author 蔡浩
   * @date 2019/4/27 17:09
   * @since 1.0.0
   */
  List<DataDto> selectInHospitalData(@Param("beginTime") Date beginTime,
      @Param("endTime") Date endTime);

  /**
   * 查询出院人数数据
   *
   * @param beginTime 开始时间
   * @param endTime 结束时间
   * @return java.util.List<com.caihao.hospitalmanager.entity.dto.DataDto>
   * @author 蔡浩
   * @date 2019/4/27 17:09
   * @since 1.0.0
   */
  List<DataDto> selectOutHospitalData(@Param("beginTime") Date beginTime,
      @Param("endTime") Date endTime);

  /**
   * 查询历史总就医人数
   *
   * @return int
   * @author 蔡浩
   * @date 2019/4/27 17:18
   * @since 1.0.0
   */
  int selectPatientCount();
}