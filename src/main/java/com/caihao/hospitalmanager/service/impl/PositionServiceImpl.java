package com.caihao.hospitalmanager.service.impl;

import com.caihao.hospitalmanager.entity.dto.DropDownDto;
import com.caihao.hospitalmanager.mapper.PositionMapper;
import com.caihao.hospitalmanager.service.PositionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author caihao
 * @date 2019/4/30 14:55
 */
@Service
public class PositionServiceImpl implements PositionService{

  @Autowired
  private PositionMapper positionMapper;

  /**
   * 获取职位下拉框信息
   *
   * @return java.util.List<com.caihao.hospitalmanager.entity.dto.DropDownDto>
   * @author 蔡浩
   * @date 2019/4/30 15:01
   * @since 1.0.0
   */
  @Override
  public List<DropDownDto> getPositionList() {
    return positionMapper.selectPositionList();
  }
}
