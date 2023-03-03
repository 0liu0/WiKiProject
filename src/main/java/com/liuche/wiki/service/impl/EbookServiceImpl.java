package com.liuche.wiki.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuche.wiki.domain.Ebook;
import com.liuche.wiki.mapper.EbookMapper;
import com.liuche.wiki.req.EbookReq;
import com.liuche.wiki.resp.EbookResp;
import com.liuche.wiki.service.EbookService;
import com.liuche.wiki.utils.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class EbookServiceImpl implements EbookService {
    @Autowired
    private EbookMapper ebookMapper;
    @Override
    public Ebook queryById(Long id) {
        return ebookMapper.queryById(id);
    }

    @Override
    public List<EbookResp> selectAll(EbookReq req) {
        List<Ebook> ebooks; // 返回的数据
        String name = req.getName();
        if (!ObjectUtils.isEmpty(name)){
            name = "%" + name + "%";
            req.setName(name);
            PageHelper.startPage(1,3);
            ebooks = ebookMapper.selectAll(req);
            PageInfo<Ebook> p = new PageInfo<>(ebooks);
            System.out.println(p.getPages());
            System.out.println(p.getTotal());
        }else {
            PageHelper.startPage(1,3);
            ebooks = ebookMapper.selectAll1();
            PageInfo<Ebook> p = new PageInfo<>(ebooks);
            System.out.println(p.getPages());
            System.out.println(p.getTotal());
        }
        return CopyUtil.copyList(ebooks, EbookResp.class);
    }
}
