package com.liuche.wiki;

import com.liuche.wiki.domain.EbookSnapshot;
import com.liuche.wiki.mapper.EbookSnapshotMapper;
import com.liuche.wiki.service.DocService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = WiKiApplication.class)
@RunWith(SpringRunner.class)
class WiKiApplicationTests {
    @Autowired
    private DocService docService;
    @Autowired
    private EbookSnapshotMapper ebookSnapshotMapper;
//    @Autowired
    private StringRedisTemplate template;

    @Test
    void contextLoads() {
        EbookSnapshot ebookSnapshot = ebookSnapshotMapper.queryById(8L);
        System.out.println(ebookSnapshot);
    }

}
