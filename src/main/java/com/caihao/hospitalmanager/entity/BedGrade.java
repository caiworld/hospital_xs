package com.caihao.hospitalmanager.entity;

import javax.persistence.*;

@Table(name = "`bed_grade`")
public class BedGrade {
    /**
     * 病床等级id
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    /**
     * 病床对应的病房名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 花销
     */
    @Column(name = "`cost`")
    private Double cost;

    /**
     * 获取病床等级id
     *
     * @return id - 病床等级id
     */
    public Short getId() {
        return id;
    }

    /**
     * 设置病床等级id
     *
     * @param id 病床等级id
     */
    public void setId(Short id) {
        this.id = id;
    }

    /**
     * 获取病床对应的病房名称
     *
     * @return name - 病床对应的病房名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置病床对应的病房名称
     *
     * @param name 病床对应的病房名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取花销
     *
     * @return cost - 花销
     */
    public Double getCost() {
        return cost;
    }

    /**
     * 设置花销
     *
     * @param cost 花销
     */
    public void setCost(Double cost) {
        this.cost = cost;
    }
}