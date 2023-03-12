package com.liuche.wiki;

import com.liuche.wiki.service.DocService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

@SpringBootTest
@RunWith(SpringRunner.class)
class WiKiApplicationTests {
    @Autowired
    private DocService docService;

    @Test
    void contextLoads() {
        String s = DigestUtils.md5DigestAsHex("".getBytes(StandardCharsets.UTF_8));
        System.out.println(s);
    }

}
