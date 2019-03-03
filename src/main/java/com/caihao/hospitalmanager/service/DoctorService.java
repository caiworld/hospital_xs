package com.caihao.hospitalmanager.service;

import com.caihao.hospitalmanager.entity.Doctor;
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
   * @return com.github.pagehelper.PageInfo<com.caihao.hospitalmanager.entity.Doctor>
   * @author 蔡浩
   * @date 2019/2/26 20:15
   * @since 1.0.0
   */
  PageInfo<Doctor> getDoctorList(Integer pageNum);
}
