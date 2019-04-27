package com.caihao.hospitalmanager.controller;

import com.caihao.hospitalmanager.entity.Result;
import com.caihao.hospitalmanager.entity.dto.ChargeDetailDto;
import com.caihao.hospitalmanager.service.ChargeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 收费信息
 *
 * @author caihao
 * @date 2019/4/22 14:02
 */
@RestController
@RequestMapping("/charge")
@Slf4j
public class ChargeController {

  @Autowired
  private ChargeService chargeService;

  /**
   * 通过病人名称或身份证号查询病人收费信息
   *
   * @param name 病人名称
   * @param number 病人身份证
   * @return com.caihao.hospitalmanager.entity.Result
   * @author 蔡浩
   * @date 2019/4/22 14:08
   * @since 1.0.0
   */
  @GetMapping("/get_list")
  public Result getChargeList(@RequestParam(defaultValue = "1") Integer pageNum, String name,
      String number) {
    return new Result(Result.OK, chargeService.getChargeList(pageNum, name, number));
  }

  /**
   * 根据病人id编辑收费信息
   *
   * @param patientId 病人id
   * @return com.caihao.hospitalmanager.entity.Result
   * @author 蔡浩
   * @date 2019/4/22 15:29
   * @since 1.0.0
   */
  @GetMapping("/edit")
  public Result editCharge(Integer patientId) {
    return new Result(Result.OK, chargeService.getChargeByPatientId(patientId));
  }

  /**
   * 保存收费信息
   *
   * @param chargeDetailDto 收费信息
   * @return com.caihao.hospitalmanager.entity.Result
   * @author 蔡浩
   * @date 2019/4/22 21:15
   * @since 1.0.0
   */
  @PostMapping("/save")
  public Result saveCharges(@RequestBody ChargeDetailDto chargeDetailDto) {
    try {
      chargeService.saveCharges(chargeDetailDto);
      return new Result(Result.OK, "保存成功");
    } catch (Exception e) {
      log.error(e.getMessage());
      return new Result(Result.ERROR, "保存失败");
    }
  }

  /**
   * 病人收费信息详情
   *
   * @param patientId 病人id
   * @return com.caihao.hospitalmanager.entity.Result
   * @author 蔡浩
   * @date 2019/4/23 11:46
   * @since 1.0.0
   */
  @GetMapping("/detail")
  public Result detailCharge(Integer patientId){
    return new Result(Result.OK, chargeService.getChargeByPatientId(patientId));
  }

}
