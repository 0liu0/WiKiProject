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
public class CategorySaveReq {
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
    @NotNull(message = "【名称】不能为空")
    private String name;
    /**
     * 顺序
     */
    private Integer sort;
}
