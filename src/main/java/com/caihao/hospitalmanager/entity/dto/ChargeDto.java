package com.caihao.hospitalmanager.entity.dto;

import com.caihao.hospitalmanager.entity.Charge;
import lombok.Data;

/**
 * TODO
 *
 * @author caihao
 * @date 2019/4/22 14:10
 */
@Data
public class ChargeDto extends Charge{
  /**
   * 病人名称
   */
  private String patientName;
  /**
   * 病人身份证号
   */
  private String number;
}
