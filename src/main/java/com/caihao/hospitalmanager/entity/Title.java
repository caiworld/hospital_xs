package com.caihao.hospitalmanager.entity;

import javax.persistence.*;

@Table(name = "`title`")
public class Title {
    /**
     * 主键
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 职称名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取职称名称
     *
     * @return name - 职称名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置职称名称
     *
     * @param name 职称名称
     */
    public void setName(String name) {
        this.name = name;
    }
}