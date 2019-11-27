package com.caihao.hospitalmanager.mapper;

import com.caihao.hospitalmanager.entity.Bed;
import com.caihao.hospitalmanager.entity.dto.BedDto;
import com.caihao.hospitalmanager.entity.dto.DropDownDto;
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

  /**
   * 根据id查询病床信息
   *
   * @param id 病床编号
   * @return com.caihao.hospitalmanager.entity.dto.BedDto
   * @author 蔡浩
   * @date 2019/4/22 11:16
   * @since 1.0.0
   */
  BedDto selectBedDtoById(Integer id);

  /**
   * 查询已使用的病床数
   *
   * @return int
   * @author 蔡浩
   * @date 2019/4/27 17:23
   * @since 1.0.0
   */
  int selectUsedBedCount();

  /**
   * 查询总病床数
   *
   * @return int
   * @author 蔡浩
   * @date 2019/4/27 17:23
   * @since 1.0.0
   */
  int selectBedCount();
  /**
   * 根据病床等级查询出一张病床
   *
   * @param bedGradeId 病床等级id
   * @return int
   * @author 蔡浩
   * @date 2019/5/29 14:17
   * @since 1.0.0
   */
  int selectFreeBedByGrade(Integer bedGradeId);
}