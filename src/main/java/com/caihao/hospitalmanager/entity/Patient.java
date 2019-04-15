package com.caihao.hospitalmanager.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`patient`")
public class Patient {
    /**
     *  病人id
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 科ids
     */
    @Column(name = "`department_ids`")
    private String departmentIds;

    /**
     * 身份证号
     */
    @Column(name = "`number`")
    private String number;

    /**
     * 姓名
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 性别（0.未知，1.男，2.女）
     */
    @Column(name = "`sex`")
    private Short sex;

    /**
     * 年龄
     */
    @Column(name = "`age`")
    private Integer age;

    /**
     * 病状
     */
    @Column(name = "`disease`")
    private String disease;

    /**
     * 医生ids
     */
    @Column(name = "`doctor_ids`")
    private String doctorIds;

    /**
     * 入院时间
     */
    @Column(name = "`in_time`")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date inTime;

    /**
     * 出院时间
     */
    @Column(name = "`exit_time`")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date exitTime;

    /**
     * 是否出院，0否，1是
     */
    @Column(name = "`is_exit`")
    private Boolean isExit;

    /**
     * 获取 病人id
     *
     * @return id -  病人id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 病人id
     *
     * @param id  病人id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取科ids
     *
     * @return department_ids - 科ids
     */
    public String getDepartmentIds() {
        return departmentIds;
    }

    /**
     * 设置科ids
     *
     * @param departmentIds 科ids
     */
    public void setDepartmentIds(String departmentIds) {
        this.departmentIds = departmentIds;
    }

    /**
     * 获取身份证号
     *
     * @return number - 身份证号
     */
    public String getNumber() {
        return number;
    }

    /**
     * 设置身份证号
     *
     * @param number 身份证号
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取性别（0.未知，1.男，2.女）
     *
     * @return sex - 性别（0.未知，1.男，2.女）
     */
    public Short getSex() {
        return sex;
    }

    /**
     * 设置性别（0.未知，1.男，2.女）
     *
     * @param sex 性别（0.未知，1.男，2.女）
     */
    public void setSex(Short sex) {
        this.sex = sex;
    }

    /**
     * 获取年龄
     *
     * @return age - 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取病状
     *
     * @return disease - 病状
     */
    public String getDisease() {
        return disease;
    }

    /**
     * 设置病状
     *
     * @param disease 病状
     */
    public void setDisease(String disease) {
        this.disease = disease;
    }

    /**
     * 获取医生ids
     *
     * @return doctor_ids - 医生ids
     */
    public String getDoctorIds() {
        return doctorIds;
    }

    /**
     * 设置医生ids
     *
     * @param doctorIds 医生ids
     */
    public void setDoctorIds(String doctorIds) {
        this.doctorIds = doctorIds;
    }

    /**
     * 获取入院时间
     *
     * @return in_time - 入院时间
     */
    public Date getInTime() {
        return inTime;
    }

    /**
     * 设置入院时间
     *
     * @param inTime 入院时间
     */
    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    /**
     * 获取出院时间
     *
     * @return exit_time - 出院时间
     */
    public Date getExitTime() {
        return exitTime;
    }

    /**
     * 设置出院时间
     *
     * @param exitTime 出院时间
     */
    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    /**
     * 获取是否出院，0否，1是
     *
     * @return is_exit - 是否出院，0否，1是
     */
    public Boolean getIsExit() {
        return isExit;
    }

    /**
     * 设置是否出院，0否，1是
     *
     * @param isExit 是否出院，0否，1是
     */
    public void setIsExit(Boolean isExit) {
        this.isExit = isExit;
    }
}