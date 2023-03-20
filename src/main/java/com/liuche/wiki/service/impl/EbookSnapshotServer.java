package com.liuche.wiki.service.impl;

import com.liuche.wiki.mapper.EbookSnapshotMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EbookSnapshotServer {
    @Autowired
    private EbookSnapshotMapper ebookSnapshotMapper;

    public void genEbookSnapshot() {
        // 更新ebook_snapshot这张表格
        ebookSnapshotMapper.genEbookSnapshot();
    }
}
