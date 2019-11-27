package com.caihao.hospitalmanager.entity.dto;

import java.util.List;
import lombok.Data;

/**
 * 病人统计dto
 *
 * @author caihao
 * @date 2019/4/27 16:51
 */
@Data
public class PatientStatisticDto {
  /**
   * 看病人数统计
   */
  private List<DataDto> diseaseList;
  /**
   * 住院人数统计
   */
  private List<DataDto> inHospitalList;
  /**
   * 出院人数统计
   */
  private List<DataDto> outHospitalList;
  /**
   * 历史总病人数
   */
  private Integer totalPatient;
  /**
   * 已使用病床数
   */
  private Integer bedUsed;
  /**
   * 总病床数
   */
  private Integer totalBed;
}
