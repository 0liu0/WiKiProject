package com.liuche.wiki.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 文档(Doc)实体类
 *
 * @author LiuChe
 * @since 2023-03-08 15:13:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doc implements Serializable {
    private static final long serialVersionUID = 834621567079219642L;
    /**
     * id
     */
    private Long id;
    /**
     * 电子书id
     */
    private Long ebookId;
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
    /**
     * 阅读数
     */
    private Integer viewCount;
    /**
     * 点赞数
     */
    private Integer voteCount;


}

