package com.caihao.hospitalmanager.controller;

import com.caihao.hospitalmanager.entity.Result;
import com.caihao.hospitalmanager.entity.dto.DoctorDto;
import com.caihao.hospitalmanager.service.DoctorService;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 医生Controller
 *
 * @Author 蔡浩
 * @Date 2019/2/26 20:09
 */
@RestController
@RequestMapping("/doctor")
public class DoctorController {
  @Autowired
  private DoctorService doctorService;

  /**
   * 获取医生信息
   *
   * @param pageNum 页数
   * @return: com.caihao.hospitalmanager.entity.Result
   * @author: 蔡浩
   * @date: 2019/3/3 16:31
   * @since: 1.0.0
   */
  @CrossOrigin
  @GetMapping("/get_doctor_list")
  public Result getDoctorList(@RequestParam(defaultValue = "1") Integer pageNum) {
    PageInfo<DoctorDto> pageInfo = doctorService.getDoctorList(pageNum);
    return new Result(Result.OK, pageInfo);
  }

}
