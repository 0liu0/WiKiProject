package com.liuche.wiki.job;

import com.liuche.wiki.service.DocService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DocJob {
    @Autowired
    private DocService docService;
    private static final Logger LOG = LoggerFactory.getLogger(DocJob.class);
    /**
     * 自定义cron表达式跑批
     * 只有等上一次执行完成，下一次才会在下一个时间点执行，错过就错过
     */
    @Scheduled(cron = "0 */2 * * * ?") // 每两小时执行一次
    public void cron() {
        LOG.info("开始更新ebook的数据");
        long start = System.currentTimeMillis();
        docService.updateEbookInfo();
        LOG.info("更新ebook的数据完成，耗时:{}秒",(System.currentTimeMillis()-start)/1000);
    }
}
