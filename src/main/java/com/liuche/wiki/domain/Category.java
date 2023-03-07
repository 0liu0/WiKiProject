package com.liuche.wiki.domain;

import java.io.Serializable;

/**
 * 分类(Category)实体类
 *
 * @author LiuChe
 * @since 2023-03-06 20:27:40
 */
public class Category implements Serializable {
    private static final long serialVersionUID = -39834754671328986L;
    /**
     * id
     */
    private Long id;
    /**
     * 父id
     */
    private Long parent;
    /**
     * 名称
     */
    private String name;
    /**
     * 顺序
     */
    private Integer sort;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

}

