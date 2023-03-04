package com.liuche.wiki.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PageReq {
    @Max(value = 1000,message = "【每条页数】不能超过1000")
    @NotNull(message = "【每页条数不能为空】")
    private int size;
    @NotNull(message = "【页码不能为空】")
    private int page;
}
