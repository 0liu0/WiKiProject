package com.liuche.wiki.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EbookQueryReq extends PageReq {
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
}
