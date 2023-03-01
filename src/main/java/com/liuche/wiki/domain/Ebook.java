package com.liuche.wiki.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 电子书(Ebook)实体类
 *
 * @author LiuChe
 * @since 2023-03-01 17:40:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ebook implements Serializable {
    private static final long serialVersionUID = 760743672321450575L;
    /**
     * id
     */
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 分类1
     */
    private Long category1Id;
    /**
     * 分类2
     */
    private Long category2Id;
    /**
     * 描述
     */
    private String description;
    /**
     * 封面
     */
    private String cover;
    /**
     * 文档数
     */
    private Integer docCount;
    /**
     * 阅读数
     */
    private Integer viewCount;
    /**
     * 点赞数
     */
    private Integer voteCount;

}

