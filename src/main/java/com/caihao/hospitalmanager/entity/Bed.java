package com.caihao.hospitalmanager.entity;

import javax.persistence.*;

@Table(name = "`bed`")
public class Bed {
    /**
     * 病床号
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 病人号
     */
    @Column(name = "`patient_id`")
    private Integer patientId;

    /**
     * 病床等级（等级越高，花费越高）
     */
    @Column(name = "`grade`")
    private Integer grade;

    /**
     * 病床状态（0.没人，1.有人）
     */
    @Column(name = "`state`")
    private Short state;

    /**
     * 是否删除（0.否，1是）
     */
    @Column(name = "`is_del`")
    private Boolean isDel;

    /**
     * 获取病床号
     *
     * @return id - 病床号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置病床号
     *
     * @param id 病床号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取病人号
     *
     * @return patient_id - 病人号
     */
    public Integer getPatientId() {
        return patientId;
    }

    /**
     * 设置病人号
     *
     * @param patientId 病人号
     */
    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    /**
     * 获取病床等级（等级越高，花费越高）
     *
     * @return grade - 病床等级（等级越高，花费越高）
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * 设置病床等级（等级越高，花费越高）
     *
     * @param grade 病床等级（等级越高，花费越高）
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    /**
     * 获取病床状态（0.没人，1.有人）
     *
     * @return state - 病床状态（0.没人，1.有人）
     */
    public Short getState() {
        return state;
    }

    /**
     * 设置病床状态（0.没人，1.有人）
     *
     * @param state 病床状态（0.没人，1.有人）
     */
    public void setState(Short state) {
        this.state = state;
    }

    /**
     * 获取是否删除（0.否，1是）
     *
     * @return is_del - 是否删除（0.否，1是）
     */
    public Boolean getIsDel() {
        return isDel;
    }

    /**
     * 设置是否删除（0.否，1是）
     *
     * @param isDel 是否删除（0.否，1是）
     */
    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }
}