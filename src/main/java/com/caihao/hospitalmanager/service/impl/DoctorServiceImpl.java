package com.caihao.hospitalmanager.service.impl;

import com.caihao.hospitalmanager.entity.Doctor;
import com.caihao.hospitalmanager.mapper.DoctorMapper;
import com.caihao.hospitalmanager.service.DoctorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
   * @return com.github.pagehelper.PageInfo<com.caihao.hospitalmanager.entity.Doctor>
   * @author 蔡浩
   * @date 2019/2/26 20:15
   * @since 1.0.0
   */
  @Override
  public PageInfo<Doctor> getDoctorList(Integer pageNum) {
    // 分页查询
    PageHelper.startPage(pageNum, PAGESIZE);
    List<Doctor> doctorList = doctorMapper.selectDoctorList();
    return new PageInfo<>(doctorList);
  }
}
