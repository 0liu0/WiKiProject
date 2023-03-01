package com.liuche.wiki.controller;

import com.liuche.wiki.req.EbookReq;
import com.liuche.wiki.resp.CommonResp;
import com.liuche.wiki.resp.EbookResp;
import com.liuche.wiki.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/ebook")
@RestController
public class EbookController {
    @Autowired
    private EbookService ebookService;

    @GetMapping("/list")
    public CommonResp list(EbookReq req){
        CommonResp<List<EbookResp>> resp = new CommonResp<>();
        List<EbookResp> ebookList = ebookService.selectAll(req); // 得到所有的ebook

        resp.setContent(ebookList);
        return resp;
    }
}
