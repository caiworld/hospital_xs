package com.caihao.hospitalmanager.controller;

import com.caihao.hospitalmanager.entity.Result;
import com.caihao.hospitalmanager.service.PatientService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据统计管理
 *
 * @author caihao
 * @date 2019/4/27 16:48
 */
@RestController
@RequestMapping("/statistic")
public class DataStatisticController {

  @Autowired
  private PatientService patientService;

  /**
   * 获取病人统计信息
   *
   * @param beginTime 开始时间
   * @param endTime 结束时间
   * @return com.caihao.hospitalmanager.entity.Result
   * @author 蔡浩
   * @date 2019/4/27 17:27
   * @since 1.0.0
   */
  @GetMapping("/get_patient")
  public Result getStatisticPatient(@DateTimeFormat(pattern = "yyyy-MM-dd") Date beginTime,
      @DateTimeFormat(pattern = "yyyy-MM-dd") Date endTime) {
    return new Result(Result.OK, patientService.getStatisticPatient(beginTime, endTime));
  }
}
