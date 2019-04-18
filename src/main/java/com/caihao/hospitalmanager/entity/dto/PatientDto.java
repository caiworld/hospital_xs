package com.caihao.hospitalmanager.entity.dto;

import com.caihao.hospitalmanager.entity.Patient;
import lombok.Data;

/**
 * @author caihao
 * @date 2019/3/28 22:04
 */
@Data
public class PatientDto extends Patient {
  /**
   * 病人所属科室的名称
   */
  private String departmentNames;
  /**
   * 给病人看病的医生名称
   */
  private String doctorNames;

}
