package com.liuche.wiki.domain;

import java.io.Serializable;

/**
 * 文档内容(Content)实体类
 *
 * @author LiuChe
 * @since 2023-03-09 19:21:36
 */
public class Content implements Serializable {
    private static final long serialVersionUID = -99640965825672885L;
    /**
     * 文档id
     */
    private Long id;
    /**
     * 内容
     */
    private String content;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}

