package com.caihao.hospitalmanager.mapper;

import com.caihao.hospitalmanager.entity.Bed;
import com.caihao.hospitalmanager.entity.dto.BedDto;
import com.caihao.hospitalmanager.generator.MyMapper;

import java.util.List;

public interface BedMapper extends MyMapper<Bed> {

  /**
   * 查询病床信息
   *
   * @return java.util.List<com.caihao.hospitalmanager.entity.dto.BedDto>
   * @author 蔡浩
   * @date 2019/4/4 17:15
   * @since 1.0.0
   */
  List<BedDto> selectBedList();
}