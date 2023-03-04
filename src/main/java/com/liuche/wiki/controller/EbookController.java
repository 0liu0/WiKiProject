package com.liuche.wiki.controller;

import com.liuche.wiki.req.EbookQueryReq;
import com.liuche.wiki.req.EbookSaveReq;
import com.liuche.wiki.resp.CommonResp;
import com.liuche.wiki.resp.EbookQueryResp;
import com.liuche.wiki.resp.PageResp;
import com.liuche.wiki.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/ebook")
@RestController
public class EbookController {
    @Autowired
    private EbookService ebookService;

    @GetMapping("/list")
    public CommonResp list(EbookQueryReq req){
        CommonResp<PageResp<EbookQueryResp>> resp = new CommonResp<>();
        PageResp<EbookQueryResp> ebookList = ebookService.selectAll(req); // 得到所有的ebook

        resp.setContent(ebookList);
        return resp;
    }
    @PostMapping("/save")
    public CommonResp save(@RequestBody EbookSaveReq req){ // @RequestBody从前端接收JSON对象时要使用这个注解
        CommonResp<Object> resp = new CommonResp<>();
        boolean b = ebookService.saveEBook(req);
        resp.setSuccess(b);
        return resp;
    }
    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id){ // @RequestBody从前端接收JSON对象时要使用这个注解
        CommonResp<Object> resp = new CommonResp<>();
        boolean b = ebookService.deleteEbook(id);
        resp.setSuccess(b);
        return resp;
    }
}
