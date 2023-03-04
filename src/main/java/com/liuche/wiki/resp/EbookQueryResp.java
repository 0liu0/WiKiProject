package com.liuche.wiki.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EbookQueryResp {
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
