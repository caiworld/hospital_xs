package com.caihao.hospitalmanager.service.impl;

import com.caihao.hospitalmanager.entity.Doctor;
import com.caihao.hospitalmanager.entity.dto.DoctorDto;
import com.caihao.hospitalmanager.mapper.DoctorMapper;
import com.caihao.hospitalmanager.service.DoctorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.caihao.hospitalmanager.Common.PAGESIZE;

/**
 * DoctorService接口的实现类
 *
 * @Author 蔡浩
 * @Date 2019/2/26 20:13
 */
@Service
public class DoctorServiceImpl implements DoctorService {

  @Autowired
  private DoctorMapper doctorMapper;

  /**
   * 获取医生信息集合
   *
   * @param pageNum      页数
   * @param name         姓名
   * @param departmentId 科室id
   * @return com.github.pagehelper.PageInfo<com.caihao.hospitalmanager.entity.Doctor>
   * @author 蔡浩
   * @date 2019/2/26 20:15
   * @since 1.0.0
   */
  @Override
  public PageInfo<DoctorDto> getDoctorList(Integer pageNum, String name, Integer departmentId) {
    // 分页查询
    PageHelper.startPage(pageNum, PAGESIZE);
    List<DoctorDto> doctorList = doctorMapper.selectDoctorList(name, departmentId);
    return new PageInfo<>(doctorList);
  }

  /**
   * 根据医生id获取医生信息
   *
   * @param id 医生id
   * @return com.caihao.hospitalmanager.entity.Doctor
   * @author 蔡浩
   * @date 2019/4/12 13:51
   * @since 1.0.0
   */
  @Override
  public Doctor getDoctorById(Integer id) {
    return doctorMapper.selectByPrimaryKey(id);
  }

  /**
   * 保存医生信息
   *
   * @param doctor 医生信息
   * @return int
   * @author 蔡浩
   * @date 2019/4/12 13:59
   * @since 1.0.0
   */
  @Override
  public int saveDoctor(Doctor doctor) {
    doctor.setCreateTime(new Date());
    return doctorMapper.insertSelective(doctor);
  }

  /**
   * 修改医生信息
   *
   * @param doctor 医生信息
   * @return int
   * @author 蔡浩
   * @date 2019/4/12 14:01
   * @since 1.0.0
   */
  @Override
  public int updateDoctor(Doctor doctor) {
    return doctorMapper.updateByPrimaryKeySelective(doctor);
  }

  /**
   * 根据医生id删除医生信息
   *
   * @param id 医生id
   * @return int
   * @author 蔡浩
   * @date 2019/4/12 14:06
   * @since 1.0.0
   */
  @Override
  public int deleteDoctorById(Integer id) {
    return doctorMapper.deleteByPrimaryKey(id);
  }
}
