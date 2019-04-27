package com.caihao.hospitalmanager.entity.dto;

import com.caihao.hospitalmanager.entity.Charge;
import lombok.Data;

import java.util.List;

/**
 * TODO
 *
 * @author caihao
 * @date 2019/4/22 15:18
 */
@Data
public class ChargeDetailDto {
  /**
   * 病人id
   */
  private Integer patientId;
  /**
   * 收费信息集合
   */
  private List<Charge> chargeList;
}
