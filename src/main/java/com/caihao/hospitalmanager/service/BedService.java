package com.caihao.hospitalmanager.service;

import com.caihao.hospitalmanager.entity.dto.BedDto;
import com.github.pagehelper.PageInfo;

/**
 * 病床service
 *
 * @Author 蔡浩
 * @Date 2019/4/4 17:04
 */
public interface BedService {
  /**
   * 查询病床信息
   *
   * @param pageNum 页数
   * @return com.github.pagehelper.PageInfo<com.caihao.hospitalmanager.entity.dto.BedDto>
   * @author 蔡浩
   * @date 2019/4/4 17:05
   * @since 1.0.0
   */
  PageInfo<BedDto> getBedList(Integer pageNum);
}
