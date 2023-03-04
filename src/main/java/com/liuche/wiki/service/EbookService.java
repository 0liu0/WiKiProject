package com.liuche.wiki.service;

import com.liuche.wiki.domain.Ebook;
import com.liuche.wiki.req.EbookQueryReq;
import com.liuche.wiki.req.EbookSaveReq;
import com.liuche.wiki.resp.EbookQueryResp;
import com.liuche.wiki.resp.PageResp;

public interface EbookService {
    Ebook queryById(Long id);

    PageResp<EbookQueryResp> selectAll(EbookQueryReq req);
    boolean saveEBook(EbookSaveReq req);
}
