package com.liuche.wiki.service.impl;

import com.liuche.wiki.domain.Ebook;
import com.liuche.wiki.mapper.EbookMapper;
import com.liuche.wiki.req.EbookReq;
import com.liuche.wiki.resp.EbookResp;
import com.liuche.wiki.service.EbookService;
import com.liuche.wiki.utils.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        String name = req.getName();
        name = "%" + name + "%";
        req.setName(name);
        List<Ebook> ebooks = ebookMapper.selectAll(req);

//        ArrayList<EbookResp> ebookList = new ArrayList<>();
//        for (Ebook ebook : ebooks){
//            EbookResp ebookResp = new EbookResp();
//            // 使用BeanUtils将两个类型相互转换
//            BeanUtils.copyProperties(ebook,ebookResp);
//            ebookList.add(ebookResp);
//        }
        return CopyUtil.copyList(ebooks, EbookResp.class);
    }
}
