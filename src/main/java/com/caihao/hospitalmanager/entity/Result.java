package com.caihao.hospitalmanager.entity;

import java.util.Objects;

/**
 * 结果集
 *
 * @Author 蔡浩
 * @Date 2019/2/26 16:40
 */
public class Result {
  public static final Integer OK = 0;
  public static final Integer ERROR = 100;

  private Integer code;
  private String message;
  private String url;
  private Object data;

  public Result(Integer code, String message, String url, Object data) {
    this.code = code;
    this.message = message;
    this.url = url;
    this.data = data;
  }

  public Result() {
  }

  public Result(Integer code, Object data) {
    this.code = code;
    this.message = Objects.equals(code, OK) ? "请求成功" : "请求失败";
    this.data = data;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }
}
