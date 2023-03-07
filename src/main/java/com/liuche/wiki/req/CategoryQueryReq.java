package com.liuche.wiki.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryQueryReq extends PageReq {
    /**
     * id
     */
    private Long id;
    /**
     * 名称
     */
    private String name;
}
