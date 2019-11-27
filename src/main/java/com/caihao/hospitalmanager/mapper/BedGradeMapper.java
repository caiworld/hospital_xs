package com.caihao.hospitalmanager.mapper;

import com.caihao.hospitalmanager.entity.BedGrade;
import com.caihao.hospitalmanager.entity.dto.DropDownDto;
import com.caihao.hospitalmanager.generator.MyMapper;

import java.util.List;

public interface BedGradeMapper extends MyMapper<BedGrade> {

  /**
   * 查询病床等级下拉框信息集合
   *
   * @return java.util.List<com.caihao.hospitalmanager.entity.dto.DropDownDto>
   * @author 蔡浩
   * @date 2019/4/22 11:37
   * @since 1.0.0
   */
  List<DropDownDto> selectDropDownDtoList();

  /**
   * 获取还有空余病床的等级下拉框信息
   *
   * @return java.util.List<com.caihao.hospitalmanager.entity.dto.DropDownDto>
   * @author 蔡浩
   * @date 2019/5/29 13:53
   * @since 1.0.0
   */
  List<DropDownDto> selectFreeBedGradeList();
}