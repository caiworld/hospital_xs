package com.caihao.hospitalmanager.controller;

import com.caihao.hospitalmanager.entity.Doctor;
import com.caihao.hospitalmanager.entity.Result;
import com.caihao.hospitalmanager.entity.dto.DoctorDto;
import com.caihao.hospitalmanager.service.DoctorService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

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
//  @CrossOrigin
  @GetMapping("/get_list")
  public Result getDoctorList(@RequestParam(defaultValue = "1") Integer pageNum) {
    PageInfo<DoctorDto> pageInfo = doctorService.getDoctorList(pageNum);
    return new Result(Result.OK, pageInfo);
  }

  /**
   * 编辑医生信息时，根据医生id获取医生信息
   *
   * @param id 医生id
   * @return com.caihao.hospitalmanager.entity.Result
   * @author 蔡浩
   * @date 2019/4/12 13:54
   * @since 1.0.0
   */
  @GetMapping("/edit")
  public Result editDoctor(Integer id) {
    return new Result(Result.OK, doctorService.getDoctorById(id));
  }

  /**
   * 保存医生
   *
   * @param doctor 医生信息
   * @return com.caihao.hospitalmanager.entity.Result
   * @author 蔡浩
   * @date 2019/4/12 14:03
   * @since 1.0.0
   */
  @PostMapping("/save")
  public Result saveDoctor(Doctor doctor) {
    if (Objects.isNull(doctor.getId())) {
      // 保存医生
      doctorService.saveDoctor(doctor);
    } else {
      // 修改医生
      doctorService.updateDoctor(doctor);
    }
    return new Result(Result.OK, "保存成功");
  }

  /**
   * 根据医生id删除医生信息
   *
   * @param id 医生id
   * @return com.caihao.hospitalmanager.entity.Result
   * @author 蔡浩
   * @date 2019/4/12 14:05
   * @since 1.0.0
   */
  @GetMapping("/delete")
  public Result deleteDoctor(Integer id) {
    return new Result(Result.OK, doctorService.deleteDoctorById(id));
  }

}
