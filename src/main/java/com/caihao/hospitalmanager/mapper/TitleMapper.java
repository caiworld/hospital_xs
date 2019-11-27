package com.caihao.hospitalmanager.mapper;

import com.caihao.hospitalmanager.entity.Title;
import com.caihao.hospitalmanager.entity.dto.DropDownDto;
import com.caihao.hospitalmanager.generator.MyMapper;
import java.util.List;

public interface TitleMapper extends MyMapper<Title> {

  /**
   * 查询职位下拉框信息
   *
   * @return java.util.List<com.caihao.hospitalmanager.entity.dto.DropDownDto>
   * @author 蔡浩
   * @date 2019/4/30 15:16
   * @since 1.0.0
   */
  List<DropDownDto> selectTitleList();
}