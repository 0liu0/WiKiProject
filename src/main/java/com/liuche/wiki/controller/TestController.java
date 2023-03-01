package com.liuche.wiki.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 这个注解点进去有ResponseBody注解，其作用是返回给浏览器json格式的内容。@Controller是返回一个页面，这个项目中用不到
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
