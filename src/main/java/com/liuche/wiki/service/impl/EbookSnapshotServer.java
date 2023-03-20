package com.liuche.wiki.service.impl;

import com.liuche.wiki.domain.EbookSnapshot;
import com.liuche.wiki.mapper.EbookSnapshotMapper;
import com.liuche.wiki.resp.StatisticResp;
import com.liuche.wiki.utils.CopyUtil;
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

    /**
     * 获取首页数值数据：总阅读数、总点赞数、今日阅读数、今日点赞数、今日预计阅读数、今日预计阅读增长
     */
    public List<StatisticResp> getStatistic() {
        return ebookSnapshotMapper.getStatistic();
    }

    /**
     * 30天数值统计
     */
    public List<StatisticResp> get30Statistic() {
        return ebookSnapshotMapper.get30Statistic();
    }
}
