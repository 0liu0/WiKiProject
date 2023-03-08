package com.liuche.wiki.service;

import com.liuche.wiki.domain.Doc;
import com.liuche.wiki.req.DocQueryReq;
import com.liuche.wiki.req.DocSaveReq;
import com.liuche.wiki.resp.DocQueryResp;
import com.liuche.wiki.resp.PageResp;

public interface DocService {
    Doc queryById(Long id);
    PageResp<DocQueryResp> selectAll(DocQueryReq req);
    boolean saveDoc(DocSaveReq req);
    boolean deleteDoc(Long id);
}
