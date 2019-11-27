package com.caihao.hospitalmanager.service.impl;

import com.caihao.hospitalmanager.entity.dto.DropDownDto;
import com.caihao.hospitalmanager.mapper.TitleMapper;
import com.caihao.hospitalmanager.service.TitleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author caihao
 * @date 2019/4/30 14:56
 */
@Service
public class TitleServiceImpl implements TitleService {

  @Autowired
  private TitleMapper titleMapper;

  /**
   * 获取职位下拉框信息
   *
   * @return java.util.List<com.caihao.hospitalmanager.entity.dto.DropDownDto>
   * @author 蔡浩
   * @date 2019/4/30 15:12
   * @since 1.0.0
   */
  @Override
  public List<DropDownDto> getTitleList() {
    return titleMapper.selectTitleList();
  }
}
