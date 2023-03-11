package com.liuche.wiki.controller;

import com.liuche.wiki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 这个注解点进去有ResponseBody注解，其作用是返回给浏览器json格式的内容。@Controller是返回一个页面，这个项目中用不到
@RequestMapping("/test")
public class TestController {
    @Value("${test.hello:shuaishuai}") // :后面的值是默认值，如果配置文件中没有提供值就会配置成默认值
    private String hello;

    @Autowired
    private UserService userService;
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!" + hello + "你最帅了哦";
    }


}
