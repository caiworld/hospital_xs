package com.caihao.hospitalmanager.controller;

import com.caihao.hospitalmanager.entity.Bed;
import com.caihao.hospitalmanager.entity.Result;
import com.caihao.hospitalmanager.service.BedService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * TODO
 *
 * @Author 蔡浩
 * @Date 2019/3/14 18:37
 */
@RestController
@RequestMapping("/bed")
public class BedController {

  @Autowired
  private BedService bedService;

  /**
   * 获取病床信息列表
   *
   * @param pageNum 页数
   * @return com.caihao.hospitalmanager.entity.Result
   * @author 蔡浩
   * @date 2019/4/12 14:33
   * @since 1.0.0
   */
  @GetMapping("/get_list")
  public Result getBedList(@RequestParam(defaultValue = "1") Integer pageNum) {
    return new Result(Result.OK, bedService.getBedList(pageNum));
  }

  /**
   * 编辑病床信息
   *
   * @param id 病床id
   * @return com.caihao.hospitalmanager.entity.Result
   * @author 蔡浩
   * @date 2019/4/12 14:33
   * @since 1.0.0
   */
  @GetMapping("/edit")
  public Result editBed(Integer id){
    return new Result(Result.OK, bedService.getBedById(id));
  }

  /**
   * 保存病床信息
   *
   * @param bed 病床
   * @return com.caihao.hospitalmanager.entity.Result
   * @author 蔡浩
   * @date 2019/4/12 14:36
   * @since 1.0.0
   */
  @PostMapping("/save")
  public Result saveBed(@RequestBody Bed bed){
    if (Objects.isNull(bed.getId())){
      // 新增病床信息
      return new Result(Result.OK, bedService.saveBed(bed));
    }else {
      // 修改病床信息
      return new Result(Result.OK, bedService.updateBed(bed));
    }
  }

  /**
   * 删除病床信息
   *
   * @param id 病床id
   * @return com.caihao.hospitalmanager.entity.Result
   * @author 蔡浩
   * @date 2019/4/12 14:40
   * @since 1.0.0
   */
  @GetMapping("/delete")
  public Result deleteBed(Integer id){
    return new Result(Result.OK, bedService.deleteBedById(id));
  }
}
