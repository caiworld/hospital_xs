package com.caihao.hospitalmanager.controller;

import com.caihao.hospitalmanager.entity.Result;
import com.caihao.hospitalmanager.service.BedService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

  @GetMapping("/get_bed_list")
  public Result getBedList(@RequestParam(defaultValue = "1") Integer pageNum) {
    return new Result(Result.OK, bedService.getBedList(pageNum));
  }
}
