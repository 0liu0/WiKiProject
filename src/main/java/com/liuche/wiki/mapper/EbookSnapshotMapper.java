package com.liuche.wiki.mapper;

import com.liuche.wiki.domain.EbookSnapshot;
import org.apache.ibatis.annotations.Param;

public interface EbookSnapshotMapper {
    EbookSnapshot queryById(@Param("id") Long id);
    void genEbookSnapshot();
}
