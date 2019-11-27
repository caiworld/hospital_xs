package com.caihao.hospitalmanager.service.impl;

import com.caihao.hospitalmanager.Common;
import com.caihao.hospitalmanager.entity.Charge;
import com.caihao.hospitalmanager.entity.dto.ChargeDetailDto;
import com.caihao.hospitalmanager.entity.dto.ChargeSumDto;
import com.caihao.hospitalmanager.mapper.ChargeMapper;
import com.caihao.hospitalmanager.service.ChargeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO
 *
 * @author caihao
 * @date 2019/4/22 14:10
 */
@Service
public class ChargeServiceImpl implements ChargeService {

  @Autowired
  private ChargeMapper chargeMapper;

  /**
   * 通过病人名称或身份证号查询病人收费信息
   *
   * @param pageNum 页数
   * @param name 病人名称
   * @param number 病人身份证
   * @return com.caihao.hospitalmanager.entity.dto.ChargeSumDto
   * @author 蔡浩
   * @date 2019/4/22 14:12
   * @since 1.0.0
   */
  @Override
  public PageInfo<ChargeSumDto> getChargeList(Integer pageNum, String name, String number) {
    PageHelper.startPage(pageNum, Common.PAGE_SIZE);
    List<ChargeSumDto> chargeSumDtoList = chargeMapper.selectChargeSumDto(name, number);
    return new PageInfo<>(chargeSumDtoList);
  }

  /**
   * 根据病人获取收费信息
   *
   * @param patientId 病人id
   * @return com.caihao.hospitalmanager.entity.dto.ChargeDto
   * @author 蔡浩
   * @date 2019/4/22 15:10
   * @since 1.0.0
   */
  @Override
  public List<Charge> getChargeByPatientId(Integer patientId) {
    return chargeMapper.getChargeListByPatientId(patientId);
  }

  /**
   * 保存收费信息
   *
   * @param chargeDetailDto 收费信息
   * @return int
   * @author 蔡浩
   * @date 2019/4/22 15:42
   * @since 1.0.0
   */
  @Override
  @Transactional(rollbackFor = Exception.class)
  public int saveCharges(ChargeDetailDto chargeDetailDto) {
    // 先删除该病人之前的收费信息
    try {
      chargeMapper.deleteByPatientId(chargeDetailDto.getPatientId());
    } catch (Exception e) {
      throw new RuntimeException("修改/删除病人收费信息失败");
    }
    // 然后添加该病人的收费信息
    Validate.isTrue(chargeMapper.insertChargeList(chargeDetailDto.getPatientId(),
        chargeDetailDto.getChargeList()) > 0, "保存收费信息失败");
    return 1;
  }
}
