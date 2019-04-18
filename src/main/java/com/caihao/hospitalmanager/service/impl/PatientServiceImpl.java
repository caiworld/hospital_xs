package com.caihao.hospitalmanager.service.impl;

import com.caihao.hospitalmanager.Common;
import com.caihao.hospitalmanager.entity.Department;
import com.caihao.hospitalmanager.entity.Doctor;
import com.caihao.hospitalmanager.entity.Patient;
import com.caihao.hospitalmanager.entity.dto.PatientDto;
import com.caihao.hospitalmanager.mapper.DepartmentMapper;
import com.caihao.hospitalmanager.mapper.DoctorMapper;
import com.caihao.hospitalmanager.mapper.PatientMapper;
import com.caihao.hospitalmanager.service.PatientService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
  @Autowired
  private DepartmentMapper departmentMapper;
  @Autowired
  private DoctorMapper doctorMapper;

  /**
   * 获取所有病人信息
   *
   * @param pageNum      页数
   * @param name         姓名
   * @param departmentId 科室id
   * @return java.util.List<com.caihao.hospitalmanager.entity.Patient>
   * @author 蔡浩
   * @date 2019/3/28 21:52
   * @since 1.0.0
   */
  @Override
  public PageInfo<PatientDto> getPatientList(Integer pageNum, String name, Integer departmentId) {
    PageHelper.startPage(pageNum, Common.PAGESIZE);
    List<PatientDto> patientDtoList = patientMapper.selectPatientList(name, departmentId);
    // 查询所有科别
    List<Department> departmentList = departmentMapper.selectAll();
    Map<Integer, String> departmentMap = new HashMap<>();
    departmentList.forEach(department -> {
      // 将科室的id和名称放到map中
      departmentMap.put(department.getId(), department.getName());
    });
    // 查询所有医生
    List<Doctor> doctorList = doctorMapper.selectAll();
    Map<Integer, String> doctorMap = new HashMap<>();
    doctorList.forEach(doctor -> {
      // 将医生的id和名字放到map中
      doctorMap.put(doctor.getId(), doctor.getName());
    });
    // 遍历每个病人，设置他的科室和医生
    patientDtoList.forEach(patientDto -> {
      // 取出科室id
      String[] departmentIds = patientDto.getDepartmentIds().split(",");
      StringBuilder sb1 = new StringBuilder();
      for (String id : departmentIds) {
        // 遍历科室id，从科室的map中通过id取名字，拼接起来
        sb1.append(departmentMap.get(Integer.valueOf(id))).append("、");
      }
      // 设置科室名称
      String departmentNames = sb1.toString();
      patientDto.setDepartmentNames(departmentNames.endsWith("、") ?
              departmentNames.substring(0, sb1.length() - 1) : departmentNames);

      // 取出医生id
      String[] doctorIds = patientDto.getDoctorIds().split(",");
      StringBuilder sb2 = new StringBuilder();
      for (String id : doctorIds) {
        // 遍历医生id，从医生的map中通过id取名字，拼接起来
        sb2.append(doctorMap.get(Integer.valueOf(id))).append("、");
      }
      // 设置医生名称
      String doctorNames = sb2.toString();
      patientDto.setDoctorNames(doctorNames.endsWith("、") ?
              doctorNames.substring(0, doctorNames.length() - 1) : doctorNames);

    });
    return new PageInfo<>(patientDtoList);
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
