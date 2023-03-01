package com.liuche.wiki.service;

import com.liuche.wiki.domain.Ebook;

import java.util.List;

public interface EbookService {
    Ebook queryById(Long id);

    List<Ebook> selectAll();
}
