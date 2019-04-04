package com.caihao.hospitalmanager.service.impl;

import com.caihao.hospitalmanager.Common;
import com.caihao.hospitalmanager.entity.dto.BedDto;
import com.caihao.hospitalmanager.mapper.BedMapper;
import com.caihao.hospitalmanager.service.BedService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 病床service实现类
 *
 * @Author 蔡浩
 * @Date 2019/4/4 17:12
 */
@Service
public class BedServiceImpl implements BedService {

  @Autowired
  private BedMapper bedMapper;

  /**
   * 查询病床信息
   *
   * @param pageNum 页数
   * @return com.github.pagehelper.PageInfo<com.caihao.hospitalmanager.entity.dto.BedDto>
   * @author 蔡浩
   * @date 2019/4/4 17:05
   * @since 1.0.0
   */
  @Override
  public PageInfo<BedDto> getBedList(Integer pageNum) {
    PageHelper.startPage(pageNum, Common.PAGESIZE);
    return new PageInfo<>(bedMapper.selectBedList());
  }
}
