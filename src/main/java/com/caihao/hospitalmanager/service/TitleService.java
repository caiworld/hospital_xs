package com.caihao.hospitalmanager.service;

import com.caihao.hospitalmanager.entity.dto.DropDownDto;
import java.util.List;

/**
 * TODO
 *
 * @author caihao
 * @date 2019/4/30 14:54
 */
public interface TitleService {

  /**
   * 获取职位下拉框信息
   *
   * @return java.util.List<com.caihao.hospitalmanager.entity.dto.DropDownDto>
   * @author 蔡浩
   * @date 2019/4/30 15:12
   * @since 1.0.0
   */
  List<DropDownDto> getTitleList();

}
