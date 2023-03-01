package com.liuche.wiki.controller;

import com.liuche.wiki.domain.Ebook;
import com.liuche.wiki.resp.CommonResp;
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
    public CommonResp list(){
        CommonResp<Object> resp = new CommonResp<>();
        List<Ebook> ebooks = ebookService.selectAll();
        resp.setContent(ebooks);
        return resp;
    }
}
