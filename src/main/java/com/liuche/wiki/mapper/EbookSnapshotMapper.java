package com.liuche.wiki.mapper;

import com.liuche.wiki.domain.EbookSnapshot;
import com.liuche.wiki.resp.StatisticResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EbookSnapshotMapper {
    EbookSnapshot queryById(@Param("id") Long id);
    void genEbookSnapshot();
    List<StatisticResp> getStatistic();

    List<StatisticResp> get30Statistic();
}
