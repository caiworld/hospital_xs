package com.caihao.hospitalmanager.service.impl;

import com.caihao.hospitalmanager.Common;
import com.caihao.hospitalmanager.entity.Bed;
import com.caihao.hospitalmanager.entity.dto.BedDto;
import com.caihao.hospitalmanager.entity.dto.BedEditDto;
import com.caihao.hospitalmanager.entity.dto.DropDownDto;
import com.caihao.hospitalmanager.mapper.BedGradeMapper;
import com.caihao.hospitalmanager.mapper.BedMapper;
import com.caihao.hospitalmanager.service.BedService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 病床service实现类
 *
 * @Author 蔡浩
 * @Date 2019/4/4 17:12
 */
@Service
public class BedServiceImpl implements BedService {

  @Autowired
  private BedMapper bedMapper;
  @Autowired
  private BedGradeMapper bedGradeMapper;

  /**
   * 查询病床信息
   *
   * @param pageNum 页数
   * @return com.github.pagehelper.PageInfo<com.caihao.hospitalmanager.entity.dto.BedDto>
   * @author 蔡浩
   * @date 2019/4/4 17:05
   * @since 1.0.0
   */
  @Override
  public PageInfo<BedDto> getBedList(Integer pageNum) {
    PageHelper.startPage(pageNum, Common.PAGE_SIZE);
    List<BedDto> bedDtoList = bedMapper.selectBedList();
    return new PageInfo<>(bedDtoList);
  }

  /**
   * 根据病床id获取病床信息
   *
   * @param id 病床id
   * @return com.caihao.hospitalmanager.entity.Bed
   * @author 蔡浩
   * @date 2019/4/12 14:35
   * @since 1.0.0
   */
  @Override
  public BedEditDto getBedById(Integer id) {
    BedEditDto bedEditDto = new BedEditDto();
    // 查询病床信息
    Bed bed = bedMapper.selectByPrimaryKey(id);
    // 查询病床等级集合信息
    List<DropDownDto> bedGradeList = bedGradeMapper.selectDropDownDtoList();
    bedEditDto.setId(bed.getId());
    bedEditDto.setGrade(bed.getGrade());
    bedEditDto.setBedGradeList(bedGradeList);
    return bedEditDto;
  }

  /**
   * 新增病床
   *
   * @param bed 病床
   * @return int
   * @author 蔡浩
   * @date 2019/4/12 14:38
   * @since 1.0.0
   */
  @Override
  public int saveBed(Bed bed) {
    return bedMapper.insertSelective(bed);
  }

  /**
   * 修改病床
   *
   * @param bed 病床
   * @return int
   * @author 蔡浩
   * @date 2019/4/12 14:38
   * @since 1.0.0
   */
  @Override
  public int updateBed(Bed bed) {
    return bedMapper.updateByPrimaryKeySelective(bed);
  }

  /**
   * 根据病床id删除病床
   *
   * @param id 病床id
   * @return int
   * @author 蔡浩
   * @date 2019/4/12 14:41
   * @since 1.0.0
   */
  @Override
  public int deleteBedById(Integer id) {
    return bedMapper.deleteByPrimaryKey(id);
  }
}
