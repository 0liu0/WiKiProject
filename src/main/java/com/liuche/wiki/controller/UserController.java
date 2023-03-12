package com.liuche.wiki.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.liuche.wiki.req.UserLoginQueryReq;
import com.liuche.wiki.req.UserPwdSaveReq;
import com.liuche.wiki.req.UserQueryReq;
import com.liuche.wiki.req.UserSaveReq;
import com.liuche.wiki.resp.CommonResp;
import com.liuche.wiki.resp.PageResp;
import com.liuche.wiki.resp.UserLoginQueryResp;
import com.liuche.wiki.resp.UserQueryResp;
import com.liuche.wiki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.nio.charset.StandardCharsets;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate template;

    @GetMapping("/list")
    public CommonResp list(@Valid UserQueryReq req){
        CommonResp<PageResp<UserQueryResp>> resp = new CommonResp<>();
        PageResp<UserQueryResp> userList = userService.selectAll(req); // 得到所有的user
        if (userList.getList().size()==0){
            resp.setMessage("未查询到");
            resp.setSuccess(false);
        }
        resp.setContent(userList);
        return resp;
    }
    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody UserSaveReq req){ // @RequestBody从前端接收JSON对象时要使用这个注解
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes(StandardCharsets.UTF_8)));
        CommonResp<Object> resp = new CommonResp<>();
        boolean b = userService.saveUser(req);
        resp.setSuccess(b);
        return resp;
    }
    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id){ // @RequestBody从前端接收JSON对象时要使用这个注解
        CommonResp<Object> resp = new CommonResp<>();
        boolean b = userService.deleteUser(id);
        resp.setSuccess(b);
        return resp;
    }

    @PostMapping("/reset-pwd")
    public CommonResp resetPwd(@Valid @RequestBody UserPwdSaveReq req){ // @RequestBody从前端接收JSON对象时要使用这个注解
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes(StandardCharsets.UTF_8)));
        CommonResp<Object> resp = new CommonResp<>();
        boolean flag = userService.resetUserPwd(req);
        if (flag) {
            resp.setMessage("修改成功");
        }else {
            resp.setSuccess(false);
            resp.setMessage("网络繁忙！");
        }
        return resp;
    }

    @PostMapping("/login")
    public CommonResp login(@Valid @RequestBody UserLoginQueryReq req) throws JsonProcessingException {
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes(StandardCharsets.UTF_8)));
        CommonResp<Object> resp = new CommonResp<>();
        UserLoginQueryResp queryResp = userService.login(req);
        resp.setMessage("登陆成功！");
        resp.setContent(queryResp);
        return resp;
    }

    @GetMapping("/layout/{token}")
    public CommonResp layOut(@PathVariable String token){
        CommonResp<Object> resp = new CommonResp<>();
        template.delete("user:info:"+token);
        resp.setMessage("退出成功！");
        return resp;
    }
}
