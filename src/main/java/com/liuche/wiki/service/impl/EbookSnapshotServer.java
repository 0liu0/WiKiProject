package com.liuche.wiki.service.impl;

import com.liuche.wiki.mapper.EbookSnapshotMapper;
import com.liuche.wiki.resp.StatisticResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EbookSnapshotServer {
    @Autowired
    private EbookSnapshotMapper ebookSnapshotMapper;

    public void genEbookSnapshot() {
        // 更新ebook_snapshot这张表格
        ebookSnapshotMapper.genEbookSnapshot();
    }

    public List<StatisticResp> getStatistic() {
        return null;
    }

    public List<StatisticResp> get30Statistic() {
        return null;
    }
}
