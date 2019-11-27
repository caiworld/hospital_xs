package com.caihao.hospitalmanager.mapper;

import com.caihao.hospitalmanager.entity.Position;
import com.caihao.hospitalmanager.entity.dto.DropDownDto;
import com.caihao.hospitalmanager.generator.MyMapper;
import java.util.List;

public interface PositionMapper extends MyMapper<Position> {

  /**
   * 查询职位信息集合
   *
   * @return java.util.List<com.caihao.hospitalmanager.entity.dto.DropDownDto>
   * @author 蔡浩
   * @date 2019/4/30 15:02
   * @since 1.0.0
   */
  List<DropDownDto> selectPositionList();
}