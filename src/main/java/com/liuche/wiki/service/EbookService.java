package com.liuche.wiki.service;

import com.liuche.wiki.domain.Ebook;
import com.liuche.wiki.req.EbookReq;
import com.liuche.wiki.resp.EbookResp;

import java.util.List;

public interface EbookService {
    Ebook queryById(Long id);

    List<EbookResp> selectAll(EbookReq req);
}
