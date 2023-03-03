package com.liuche.wiki.service;

import com.liuche.wiki.domain.Ebook;
import com.liuche.wiki.req.EbookReq;
import com.liuche.wiki.resp.EbookResp;
import com.liuche.wiki.resp.PageResp;

public interface EbookService {
    Ebook queryById(Long id);

    PageResp<EbookResp> selectAll(EbookReq req);
}
