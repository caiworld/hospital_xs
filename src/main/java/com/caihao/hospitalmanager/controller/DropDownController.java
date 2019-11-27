package com.caihao.hospitalmanager.controller;

import com.caihao.hospitalmanager.entity.Result;
import com.caihao.hospitalmanager.service.BedGradeService;
import com.caihao.hospitalmanager.service.BedService;
import com.caihao.hospitalmanager.service.DepartmentService;
import com.caihao.hospitalmanager.service.DoctorService;
import com.caihao.hospitalmanager.service.PositionService;
import com.caihao.hospitalmanager.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 下拉框controller
 *
 * @author caihao
 * @date 2019/4/18 13:35
 */
@RestController
@RequestMapping("/dropdown")
public class DropDownController {

  @Autowired
  private DepartmentService departmentService;
  @Autowired
  private PositionService positionService;
  @Autowired
  private TitleService titleService;
  @Autowired
  private DoctorService doctorService;
  @Autowired
  private BedGradeService bedGradeService;

  /**
   * 获取科室下拉框信息
   *
   * @return com.caihao.hospitalmanager.entity.Result
   * @author 蔡浩
   * @date 2019/4/18 13:39
   * @since 1.0.0
   */
  @GetMapping("/get_department_list")
  public Result getDepartmentList() {
    return new Result(Result.OK, departmentService.getDepartmentList());
  }

  /**
   * 获取职位下拉框信息
   *
   * @return com.caihao.hospitalmanager.entity.Result
   * @author 蔡浩
   * @date 2019/4/30 14:52
   * @since 1.0.0
   */
  @GetMapping("/get_position_list")
  public Result getPositionList(){
    return new Result(Result.OK, positionService.getPositionList());
  }
  /**
   * 获取职称下拉框信息
   *
   * @return com.caihao.hospitalmanager.entity.Result
   * @author 蔡浩
   * @date 2019/4/30 14:52
   * @since 1.0.0
   */
  @GetMapping("/get_title_list")
  public Result getTitleList(){
    return new Result(Result.OK, titleService.getTitleList());
  }

  /**
   * 根据科室id获取医生下拉框信息
   *
   * @param departmentId 科室id
   * @return com.caihao.hospitalmanager.entity.Result
   * @author 蔡浩
   * @date 2019/4/30 15:40
   * @since 1.0.0
   */
  @GetMapping("/get_doctor_list")
  public Result getDoctorListByDepartmentId(Integer departmentId){
    return new Result(Result.OK, doctorService.getDoctorListByDepartmentId(departmentId));
  }

  @GetMapping("/get_bed_grade_list")
  public Result getBedList(){
    return new Result(Result.OK,bedGradeService.getFreeBedGradeList());
  }
}
