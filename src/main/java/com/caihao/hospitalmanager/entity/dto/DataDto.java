package com.caihao.hospitalmanager.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.Data;

/**
 * 数据dto
 *
 * @author caihao
 * @date 2019/4/27 16:54
 */
@Data
public class DataDto {
  /**
   * 数量
   */
  private Integer dataCount;
  /**
   * 时间
   */
  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
  private Date dataTime;
}
