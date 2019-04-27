package com.caihao.hospitalmanager.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`charge`")
public class Charge {
    /**
     * 主键id
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 病人id
     */
    @Column(name = "`patient_id`")
    private Integer patientId;

    /**
     * 收费项目名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 单价
     */
    @Column(name = "`price`")
    private Double price;

    /**
     * 数量
     */
    @Column(name = "`num`")
    private Integer num;

    /**
     * 总价
     */
    @Column(name = "`total`")
    private Double total;

    /**
     * 开始日期
     */
    @Column(name = "`begin_time`")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date beginTime;

    /**
     * 结束日期
     */
    @Column(name = "`end_time`")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取病人id
     *
     * @return patient_id - 病人id
     */
    public Integer getPatientId() {
        return patientId;
    }

    /**
     * 设置病人id
     *
     * @param patientId 病人id
     */
    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    /**
     * 获取收费项目名称
     *
     * @return name - 收费项目名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置收费项目名称
     *
     * @param name 收费项目名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取单价
     *
     * @return price - 单价
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置单价
     *
     * @param price 单价
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 获取数量
     *
     * @return num - 数量
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 设置数量
     *
     * @param num 数量
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 获取总价
     *
     * @return total - 总价
     */
    public Double getTotal() {
        return total;
    }

    /**
     * 设置总价
     *
     * @param total 总价
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * 获取开始日期
     *
     * @return begin_time - 开始日期
     */
    public Date getBeginTime() {
        return beginTime;
    }

    /**
     * 设置开始日期
     *
     * @param beginTime 开始日期
     */
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * 获取结束日期
     *
     * @return end_time - 结束日期
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置结束日期
     *
     * @param endTime 结束日期
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}