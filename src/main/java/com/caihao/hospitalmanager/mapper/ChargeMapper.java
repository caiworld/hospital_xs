package com.caihao.hospitalmanager.mapper;

import com.caihao.hospitalmanager.entity.Charge;
import com.caihao.hospitalmanager.entity.dto.ChargeDto;
import com.caihao.hospitalmanager.entity.dto.ChargeSumDto;
import com.caihao.hospitalmanager.generator.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChargeMapper extends MyMapper<Charge> {

  /**
   * 通过病人名称或身份证号查询病人收费信息
   *
   * @param name   病人名称
   * @param number 病人身份证
   * @return java.util.List<com.caihao.hospitalmanager.entity.dto.ChargeDto>
   * @author 蔡浩
   * @date 2019/4/22 14:15
   * @since 1.0.0
   */
  List<ChargeDto> selectChargeDtoList(@Param("name") String name, @Param("number") String number);

  /**
   * 通过病人编号获取收费信息
   *
   * @param patientId 病人编号
   * @return java.util.List<com.caihao.hospitalmanager.entity.Charge>
   * @author 蔡浩
   * @date 2019/4/22 15:25
   * @since 1.0.0
   */
  List<Charge> getChargeListByPatientId(Integer patientId);

  /**
   * 根据病人id删除收费信息
   *
   * @param patientId 病人id
   * @return int
   * @author 蔡浩
   * @date 2019/4/22 15:50
   * @since 1.0.0
   */
  int deleteByPatientId(Integer patientId);

  /**
   * 批量插入收费信息
   *
   * @param patientId  病人id
   * @param chargeList 收费信息集合
   * @return int
   * @author 蔡浩
   * @date 2019/4/22 20:38
   * @since 1.0.0
   */
  int insertChargeList(@Param("patientId") Integer patientId, @Param("chargeList") List<Charge> chargeList);

  /**
   * 查询收费信息综合
   *
   * @param name 病人姓名
   * @param number 病人身份证号
   * @return com.caihao.hospitalmanager.entity.dto.ChargeSumDto
   * @author 蔡浩
   * @date 2019/4/27 15:04
   * @since 1.0.0
   */
  List<ChargeSumDto> selectChargeSumDto(@Param("name") String name, @Param("number") String number);
}