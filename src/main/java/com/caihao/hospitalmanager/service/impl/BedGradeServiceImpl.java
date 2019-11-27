package com.caihao.hospitalmanager.service.impl;

import com.caihao.hospitalmanager.entity.dto.DropDownDto;
import com.caihao.hospitalmanager.mapper.BedGradeMapper;
import com.caihao.hospitalmanager.service.BedGradeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author caihao
 * @date 2019/5/29 13:47
 */
@Service
public class BedGradeServiceImpl implements BedGradeService {
  @Autowired
  private BedGradeMapper bedGradeMapper;

  /**
   * 获取还有空余病床的等级下拉框信息
   *
   * @return java.util.List<com.caihao.hospitalmanager.entity.dto.DropDownDto>
   * @author 蔡浩
   * @date 2019/5/29 13:46
   * @since 1.0.0
   */
  @Override
  public List<DropDownDto> getFreeBedGradeList() {
    return bedGradeMapper.selectFreeBedGradeList();
  }
}
