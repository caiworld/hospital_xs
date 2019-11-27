package com.caihao.hospitalmanager.service.impl;

import com.caihao.hospitalmanager.Common;
import com.caihao.hospitalmanager.entity.Bed;
import com.caihao.hospitalmanager.entity.Charge;
import com.caihao.hospitalmanager.entity.Department;
import com.caihao.hospitalmanager.entity.Doctor;
import com.caihao.hospitalmanager.entity.Patient;
import com.caihao.hospitalmanager.entity.dto.DataDto;
import com.caihao.hospitalmanager.entity.dto.PatientDto;
import com.caihao.hospitalmanager.entity.dto.PatientStatisticDto;
import com.caihao.hospitalmanager.mapper.BedMapper;
import com.caihao.hospitalmanager.mapper.ChargeMapper;
import com.caihao.hospitalmanager.mapper.DepartmentMapper;
import com.caihao.hospitalmanager.mapper.DoctorMapper;
import com.caihao.hospitalmanager.mapper.PatientMapper;
import com.caihao.hospitalmanager.service.PatientService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
  @Autowired
  private BedMapper bedMapper;
  @Autowired
  private ChargeMapper chargeMapper;

  /**
   * 获取所有病人信息
   *
   * @param pageNum 页数
   * @param name 姓名
   * @param departmentId 科室id
   * @return java.util.List<com.caihao.hospitalmanager.entity.Patient>
   * @author 蔡浩
   * @date 2019/3/28 21:52
   * @since 1.0.0
   */
  @Override
  public PageInfo<PatientDto> getPatientList(Integer pageNum, String name, Integer departmentId) {
    PageHelper.startPage(pageNum, Common.PAGE_SIZE);
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
  @Transactional(rollbackFor = Exception.class)
  public int savePatient(Patient patient) {
    // 插入病人
    Validate.isTrue(patientMapper.insertSelective(patient) > 0, "插入病人信息失败");
    // 插入病床
    if (Objects.nonNull(patient.getBedGradeId())) {
      Bed bed = new Bed();
      int bedId = bedMapper.selectFreeBedByGrade(patient.getBedGradeId());
      bed.setId(bedId);
      bed.setPatientId(patient.getId());
      bed.setState((short) 1);
      Validate.isTrue(bedMapper.updateByPrimaryKeySelective(bed) > 0, "给病人安排病床失败");
      // 更新病人的病床
      Patient newPatient = new Patient();
      newPatient.setId(patient.getId());
      newPatient.setBedId(bedId);
      Validate.isTrue(patientMapper.updateByPrimaryKeySelective(newPatient) > 0, "给病人安排病床失败");
    }
    // 插入收费信息
    Charge charge = new Charge();
    charge.setPatientId(patient.getId());
    Validate.isTrue(chargeMapper.insertSelective(charge) > 0, "插入收费信息失败");
    return patient.getId();
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
  @Transactional(rollbackFor = Exception.class)
  public int updatePatient(Patient patient) {
    // 修改病床信息
    // 先查询原来的病床等级和现在是否一样
    Patient oldPatient = patientMapper.selectByPrimaryKey(patient.getId());
    // 如果已出院
    if (patient.getIsExit()) {
      // 清除原先的病床信息
      Bed bed = new Bed();
      bed.setId(patient.getBedId());
      bed.setPatientId(0);
      bed.setState((short) 0);
      Validate.isTrue(bedMapper.updateByPrimaryKeySelective(bed) > 0, "修改病床信息失败");
    } else {
      if (!Objects.equals(oldPatient.getBedGradeId(), patient.getBedGradeId())) {
        // 不一样说明修改了病床等级，需要重新生成一张病床
        // 如果之前的病床不为空，需要先清除掉原先的病床
        if (Objects.nonNull(oldPatient.getBedId())) {
          Bed bed = new Bed();
          bed.setId(patient.getBedId());
          bed.setPatientId(0);
          bed.setState((short) 0);
          Validate.isTrue(bedMapper.updateByPrimaryKeySelective(bed) > 0, "修改病床信息失败");
        }
        // 选出一张新等级的病床
        int bedId = bedMapper.selectFreeBedByGrade(patient.getBedGradeId());
        // 设置新病床
        patient.setBedId(bedId);
        // 给病床插入新的病人信息
        Bed newBed = new Bed();
        newBed.setId(bedId);
        newBed.setState((short) 1);
        newBed.setPatientId(patient.getId());
        bedMapper.updateByPrimaryKeySelective(newBed);
      }
    }
    // 修改病人信息
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

  /**
   * 获取病人统计信息
   *
   * @param beginTime 开始时间
   * @param endTime 结束时间
   * @return com.caihao.hospitalmanager.entity.dto.PatientStatisticDto
   * @author 蔡浩
   * @date 2019/4/27 17:03
   * @since 1.0.0
   */
  @Override
  public PatientStatisticDto getStatisticPatient(Date beginTime, Date endTime) {
    PatientStatisticDto patientStatisticDto = new PatientStatisticDto();
    // 查询看病人数数据
    List<DataDto> diseaseList = patientMapper.selectDiseaseData(beginTime, endTime);
    // 查询住院人数数据
    List<DataDto> inHospitalList = patientMapper.selectInHospitalData(beginTime, endTime);
    // 查询出院人数数据
    List<DataDto> outHospitalList = patientMapper.selectOutHospitalData(beginTime, endTime);
    // 查询历史总就医人数
    int totalPatient = patientMapper.selectPatientCount();
    // 查询目前病床使用数量
    int bedUsed = bedMapper.selectUsedBedCount();
    // 查询病床总数量
    int totalBed = bedMapper.selectBedCount();
    patientStatisticDto.setDiseaseList(diseaseList);
    patientStatisticDto.setInHospitalList(inHospitalList);
    patientStatisticDto.setOutHospitalList(outHospitalList);
    patientStatisticDto.setTotalPatient(totalPatient);
    patientStatisticDto.setBedUsed(bedUsed);
    patientStatisticDto.setTotalBed(totalBed);
    return patientStatisticDto;
  }
}
