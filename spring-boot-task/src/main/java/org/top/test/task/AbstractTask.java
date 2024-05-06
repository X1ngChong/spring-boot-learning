package org.top.test.task;

import lombok.extern.slf4j.Slf4j;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.sleep;

@Slf4j
public abstract class AbstractTask {
    
    public void doTaskOne() throws InterruptedException {
        log.info("开始做任务一");
        long startTime = currentTimeMillis();
        sleep(3000);
        long endTime = currentTimeMillis();
        log.info("做任务一,耗时{}毫秒",endTime - startTime);
    }

    public void doTaskTwo() throws InterruptedException {
        log.info("开始做任务二");
        long startTime = currentTimeMillis();
        sleep(3000);
        long endTime = currentTimeMillis();
        log.info("做任务二,耗时{}毫秒",endTime - startTime);
    }

    public void doTaskThree() throws InterruptedException {
        log.info("开始做任务三");
        long startTime = currentTimeMillis();
        sleep(3000);
        long endTime = currentTimeMillis();
        log.info("做任务三,耗时{}毫秒",endTime - startTime);
    }
}
