package com.liuche.wiki.req;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DocSaveReq {
    /**
     * id
     */
    private Long id;
    /**
     * 电子书id
     */
    @NotNull(message = "【电子书id】不能为空")
    private Long ebookId;
    /**
     * 父id
     */
    @NotNull(message = "【父id】不能为空")
    private Long parent;
    /**
     * 名称
     */
    @NotNull(message = "【名称】不能为空")
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

    private String content;


}
