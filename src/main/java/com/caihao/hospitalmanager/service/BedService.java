package com.caihao.hospitalmanager.service;

import com.caihao.hospitalmanager.entity.Bed;
import com.caihao.hospitalmanager.entity.dto.BedDto;
import com.caihao.hospitalmanager.entity.dto.BedEditDto;
import com.caihao.hospitalmanager.entity.dto.DropDownDto;
import com.github.pagehelper.PageInfo;
import java.util.List;

/**
 * 病床service
 *
 * @Author 蔡浩
 * @Date 2019/4/4 17:04
 */
public interface BedService {
  /**
   * 查询病床信息
   *
   * @param pageNum 页数
   * @return com.github.pagehelper.PageInfo<com.caihao.hospitalmanager.entity.dto.BedDto>
   * @author 蔡浩
   * @date 2019/4/4 17:05
   * @since 1.0.0
   */
  PageInfo<BedDto> getBedList(Integer pageNum);

  /**
   * 根据病床id获取病床信息
   *
   * @param id 病床id
   * @return com.caihao.hospitalmanager.entity.Bed
   * @author 蔡浩
   * @date 2019/4/12 14:35
   * @since 1.0.0
   */
  BedEditDto getBedById(Integer id);

  /**
   * 新增病床
   *
   * @param bed 病床
   * @return int
   * @author 蔡浩
   * @date 2019/4/12 14:38
   * @since 1.0.0
   */
  int saveBed(Bed bed);

  /**
   * 修改病床
   *
   * @param bed 病床
   * @return int
   * @author 蔡浩
   * @date 2019/4/12 14:38
   * @since 1.0.0
   */
  int updateBed(Bed bed);

  /**
   * 根据病床id删除病床
   *
   * @param id 病床id
   * @return int
   * @author 蔡浩
   * @date 2019/4/12 14:41
   * @since 1.0.0
   */
  int deleteBedById(Integer id);
}
