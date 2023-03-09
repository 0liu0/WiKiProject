package com.liuche.wiki.controller;

import com.liuche.wiki.req.DocQueryReq;
import com.liuche.wiki.req.DocSaveReq;
import com.liuche.wiki.resp.DocQueryResp;
import com.liuche.wiki.resp.CommonResp;
import com.liuche.wiki.resp.PageResp;
import com.liuche.wiki.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/doc")
@RestController
public class DocController {
    @Autowired
    private DocService docService;

    @GetMapping("/list")
    public CommonResp list(@Valid DocQueryReq req){
        CommonResp<PageResp<DocQueryResp>> resp = new CommonResp<>();
        PageResp<DocQueryResp> docList = docService.selectAll(req); // 得到所有的doc

        resp.setContent(docList);
        return resp;
    }
    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody DocSaveReq req){ // @RequestBody从前端接收JSON对象时要使用这个注解
        CommonResp<Object> resp = new CommonResp<>();
        boolean b = docService.saveDoc(req);
        resp.setSuccess(b);
        return resp;
    }
    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id){ // @RequestBody从前端接收JSON对象时要使用这个注解
        CommonResp<Object> resp = new CommonResp<>();
        boolean b = docService.deleteDoc(id);
        resp.setSuccess(b);
        return resp;
    }
    @GetMapping("/get-content/{id}")
    public CommonResp getContent(@PathVariable Long id){ // @RequestBody从前端接收JSON对象时要使用这个注解
        CommonResp<Object> resp = new CommonResp<>();
        String str = null;
        try {
            str = docService.selectOne(id);
            resp.setContent(str);
        } catch (NullPointerException e) {
            resp.setContent("");
        }
        return resp;
    }
}
