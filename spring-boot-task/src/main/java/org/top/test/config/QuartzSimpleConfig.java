package org.top.test.config;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.top.test.job.QuartzSimpleTask;

/**
 * @author JXS
 */
@Configuration
public class QuartzSimpleConfig {
    //指定具体的定时任务类
    @Bean
    public JobDetail uploadTaskDetail() {
        return JobBuilder.newJob(QuartzSimpleTask.class)
                .withIdentity("QuartzSimpleTask")
                .storeDurably().build();
    }

    @Bean
    public Trigger uploadTaskTrigger() {
        //这里设定触发执行的方式   0 0 23 * * * //每天晚上23点 如果修改的话需要直接修改数据库改这边没用
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        // 返回任务触发器
        return TriggerBuilder.newTrigger().forJob(uploadTaskDetail())
                .withIdentity("QuartzSimpleTask")
                .withSchedule(scheduleBuilder)
                .build();
    }
}