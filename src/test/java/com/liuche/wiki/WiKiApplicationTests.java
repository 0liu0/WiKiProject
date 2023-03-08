package com.liuche.wiki;

import com.liuche.wiki.domain.Doc;
import com.liuche.wiki.service.DocService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class WiKiApplicationTests {
    @Autowired
    private DocService docService;

    @Test
    void contextLoads() {
        Doc doc = docService.queryById(1L);
        System.out.println(doc);
    }

}
