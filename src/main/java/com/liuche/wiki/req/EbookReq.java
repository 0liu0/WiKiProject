package com.liuche.wiki.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EbookReq {
    /**
     * id
     */
    private Long id;
    /**
     * 名称
     */
    private String name;
}
