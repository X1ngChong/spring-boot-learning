package org.top.test.job;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import static java.lang.Thread.sleep;

/**
 * @author JXS
 */
@Component
@Slf4j
public class ScheduledJobs {

//    @Scheduled(fixedDelay = 5000)
//    public void fixedDelay() throws InterruptedException{
//        log.info("fixedDelay start:{}",new Date());
//        log.info("fixedDelay end:{}",new Date());
//    }
//
//    @Scheduled(fixedRate = 4000)
//    public void fixedRateJob() throws InterruptedException{
//        log.info("fixedRateJobs start:{}",new Date());
//        log.info("fixedRateJobs end:{}",new Date());
//    }

//    @Scheduled(cron = "0 13 16 6 5 * ")
//    public void cronJob() throws InterruptedException{
//        log.info("生日快乐 :{}",new Date());
//    }

    @Scheduled(cron = "0/5 * * * * ? ")
    public void fixedRateJob() throws InterruptedException{
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        QrCodeUtil.generate(time, 300, 300, FileUtil.file("D:\\demo\\springdemo\\spring-boot-learning\\spring-boot-task\\src\\main\\resources\\picture\\"+ UUID.randomUUID() +".jpg"));
    }


}
