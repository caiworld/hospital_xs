package com.caihao.hospitalmanager.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.Data;

/**
 * 收费信息综合
 *
 * @author caihao
 * @date 2019/4/27 14:59
 */
@Data
public class ChargeSumDto {

  /**
   * 病人id
   */
  private Integer patientId;
  /**
   * 病人名字
   */
  private String patientName;
  /**
   * 病人身份证
   */
  private String number;
  /**
   * 费用总计
   */
  private Double sum;
  /**
   * 开始时间
   */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date beginTime;
  /**
   * 结束时间
   */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date endTime;
}
