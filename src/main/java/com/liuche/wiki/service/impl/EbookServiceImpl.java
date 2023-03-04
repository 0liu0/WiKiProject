package com.liuche.wiki.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuche.wiki.domain.Ebook;
import com.liuche.wiki.mapper.EbookMapper;
import com.liuche.wiki.req.EbookQueryReq;
import com.liuche.wiki.req.EbookSaveReq;
import com.liuche.wiki.resp.EbookQueryResp;
import com.liuche.wiki.resp.PageResp;
import com.liuche.wiki.service.EbookService;
import com.liuche.wiki.utils.CopyUtil;
import com.liuche.wiki.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class EbookServiceImpl implements EbookService {
    @Autowired
    private EbookMapper ebookMapper;
    @Autowired
    private SnowFlake snowFlake;
    @Override
    public Ebook queryById(Long id) {
        return ebookMapper.queryById(id);
    }


    @Override
    public PageResp<EbookQueryResp> selectAll(EbookQueryReq req) {
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
        List<EbookQueryResp> ebookQueryResp = CopyUtil.copyList(ebooks, EbookQueryResp.class); // 转化
        PageResp<EbookQueryResp> pageResp = new PageResp<>(); // 定义返回的信息
        pageResp.setList(ebookQueryResp); // 将ebooks装入pageResp中
        pageResp.setTotal(p.getTotal()); // 将数据库总量装入返回值中
        return pageResp;
    }

    @Override
    public boolean saveEBook(EbookSaveReq req) {
        try {
            Ebook ebook = CopyUtil.copy(req, Ebook.class);
            if (!ObjectUtils.isEmpty(ebook.getId())){
                ebookMapper.saveEBook(ebook);
            }else { // 执行新增的逻辑
                ebook.setId(snowFlake.nextId());
                ebookMapper.saveEBook2(ebook);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteEbook(Long id) {
        try {
            ebookMapper.deleteEbook(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
