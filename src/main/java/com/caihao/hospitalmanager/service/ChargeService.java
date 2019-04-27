package com.caihao.hospitalmanager.service;

import com.caihao.hospitalmanager.entity.Charge;
import com.caihao.hospitalmanager.entity.dto.ChargeDetailDto;
import com.caihao.hospitalmanager.entity.dto.ChargeDto;
import com.caihao.hospitalmanager.entity.dto.ChargeSumDto;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * TODO
 *
 * @author caihao
 * @date 2019/4/22 14:09
 */
public interface ChargeService {
  /**
   * 通过病人名称或身份证号查询病人收费信息
   *
   * @param pageNum 页数
   * @param name   病人名称
   * @param number 病人身份证
   * @return com.caihao.hospitalmanager.entity.dto.ChargeSumDto
   * @author 蔡浩
   * @date 2019/4/22 14:12
   * @since 1.0.0
   */
  PageInfo<ChargeSumDto> getChargeList(Integer pageNum, String name, String number);

  /**
   * 根据病人获取收费信息
   *
   * @param patientId 病人id
   * @return com.caihao.hospitalmanager.entity.dto.ChargeDto
   * @author 蔡浩
   * @date 2019/4/22 15:10
   * @since 1.0.0
   */
  List<Charge> getChargeByPatientId(Integer patientId);

  /**
   * 保存收费信息
   *
   * @param chargeDetailDto 收费信息
   * @return int
   * @author 蔡浩
   * @date 2019/4/22 15:42
   * @since 1.0.0
   */
  int saveCharges(ChargeDetailDto chargeDetailDto);
}
