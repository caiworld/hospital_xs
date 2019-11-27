package com.caihao.hospitalmanager.service;

import com.caihao.hospitalmanager.entity.dto.DropDownDto;
import java.util.List;

/**
 * TODO
 *
 * @author caihao
 * @date 2019/5/29 13:45
 */
public interface BedGradeService {

  /**
   * 获取还有空余病床的等级下拉框信息
   *
   * @return java.util.List<com.caihao.hospitalmanager.entity.dto.DropDownDto>
   * @author 蔡浩
   * @date 2019/5/29 13:46
   * @since 1.0.0
   */
  List<DropDownDto> getFreeBedGradeList();
}
