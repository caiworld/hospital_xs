package com.caihao.hospitalmanager.mapper;

import com.caihao.hospitalmanager.entity.Charge;
import org.apache.commons.lang3.Validate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * TODO
 *
 * @author caihao
 * @date 2019/4/22 20:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ChargeMapperTest {
  @Autowired
  private ChargeMapper chargeMapper;

  /**
   * 测试批量插入收费信息
   *
   * @author 蔡浩
   * @date 2019/4/22 21:11
   * @since 1.0.0
   */
  @Test
  public void insertChargeList() {
    List<Charge> chargeList = new ArrayList<>();
    Charge charge = new Charge();
    charge.setName("打针");
    charge.setPrice(15.0);
    charge.setNum(1);
    charge.setTotal(15.0);
    chargeList.add(charge);
    Charge charge1 = new Charge();
    charge1.setName("把脉");
    charge1.setPrice(6.0);
    charge1.setNum(1);
    charge1.setTotal(6.0);
    chargeList.add(charge1);
    Validate.isTrue(chargeMapper.insertChargeList(3, chargeList) > 0, "插入失败");
  }
}