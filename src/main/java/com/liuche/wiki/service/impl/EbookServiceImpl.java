package com.liuche.wiki.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuche.wiki.domain.Ebook;
import com.liuche.wiki.mapper.EbookMapper;
import com.liuche.wiki.req.EbookReq;
import com.liuche.wiki.resp.EbookResp;
import com.liuche.wiki.resp.PageResp;
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
    public PageResp<EbookResp> selectAll(EbookReq req) {
        List<Ebook> ebooks; // 返回的数据
        String name = req.getName();
        if (!ObjectUtils.isEmpty(name)){
            name = "%" + name + "%";
            req.setName(name);
            PageHelper.startPage(req.getPage(), req.getSize()); // TODO 如果都没有的话就是不做分页
            ebooks = ebookMapper.selectAll(req);
        }else {
            PageHelper.startPage(req.getPage(), req.getSize());
            ebooks = ebookMapper.selectAll1();
        }
        PageInfo<Ebook> p = new PageInfo<>(ebooks); // 得到mysql中这些数据的信息
        List<EbookResp> ebookResp = CopyUtil.copyList(ebooks, EbookResp.class); // 转化
        PageResp<EbookResp> pageResp = new PageResp<>(); // 定义返回的信息
        pageResp.setList(ebookResp); // 将ebooks装入pageResp中
        pageResp.setTotal(p.getTotal()); // 将数据库总量装入返回值中
        return pageResp;
    }
}
