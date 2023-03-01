package com.liuche.wiki.service.impl;

import com.liuche.wiki.domain.Ebook;
import com.liuche.wiki.mapper.EbookMapper;
import com.liuche.wiki.service.EbookService;
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
    public List<Ebook> selectAll() {
        return ebookMapper.selectAll();
    }
}
