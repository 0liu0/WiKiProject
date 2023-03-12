package com.liuche.wiki;

import com.liuche.wiki.service.DocService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class WiKiApplicationTests {
    @Autowired
    private DocService docService;
//    @Autowired
    private StringRedisTemplate template;

    @Test
    void contextLoads() {
        Boolean delete = template.delete("user:info:0b3ef860-9933-4970-ae55-a210053af61e");
        System.out.println(delete);
    }

}
