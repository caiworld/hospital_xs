package com.caihao.hospitalmanager.service;

import com.caihao.hospitalmanager.entity.Doctor;
import com.caihao.hospitalmanager.entity.dto.DoctorDto;
import com.github.pagehelper.PageInfo;

/**
 * Doctor服务接口
 *
 * @Author 蔡浩
 * @Date 2019/2/26 20:12
 */
public interface DoctorService {

  /**
   * 获取医生信息集合
   *
   * @param pageNum 页数
   * @return com.github.pagehelper.PageInfo<com.caihao.hospitalmanager.entity.Doctor>
   * @author 蔡浩
   * @date 2019/2/26 20:15
   * @since 1.0.0
   */
  PageInfo<DoctorDto> getDoctorList(Integer pageNum);

  /**
   * 根据医生id获取医生信息
   *
   * @param id 医生id
   * @return com.caihao.hospitalmanager.entity.Doctor
   * @author 蔡浩
   * @date 2019/4/12 13:51
   * @since 1.0.0
   */
  Doctor getDoctorById(Integer id);

  /**
   * 保存医生信息
   *
   * @param doctor 医生信息
   * @return int
   * @author 蔡浩
   * @date 2019/4/12 13:59
   * @since 1.0.0
   */
  int saveDoctor(Doctor doctor);

  /**
   * 修改医生信息
   *
   * @param doctor 医生信息
   * @return int
   * @author 蔡浩
   * @date 2019/4/12 14:01
   * @since 1.0.0
   */
  int updateDoctor(Doctor doctor);

  /**
   * 根据医生id删除医生信息
   *
   * @param id 医生id
   * @return int
   * @author 蔡浩
   * @date 2019/4/12 14:06
   * @since 1.0.0
   */
  int deleteDoctorById(Integer id);
}
