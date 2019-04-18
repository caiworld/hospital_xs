package com.caihao.hospitalmanager.generator;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * TODO
 *
 * @Author 蔡浩
 * @Date 2019/2/18 17:24
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
