package org.top.test.service;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.top.test.entity.CronTriggers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DataBaseServiceTest {

     @Resource
     DataBaseService dataBaseService;
    @Test
    void selData() {
        dataBaseService.selAllData();
    }
    @Test
    void test(){
        List<CronTriggers> all = dataBaseService.selAllData(); // Assume this retrieves the data
        writeDataToExcel(all);
    }

    void writeDataToExcel(List<CronTriggers> dataList) {
        // 创建Excel写入器
        ExcelWriter writer = ExcelUtil.getWriter("D:\\demo\\springdemo\\spring-boot-learning\\spring-boot-task\\src\\main\\resources\\output.xlsx");


        writer.autoSizeColumnAll();  // 自适应单元格大小

        // 写入表头
        writer.addHeaderAlias("schedName", "SCHED_NAME");
        writer.addHeaderAlias("triggerName", "TRIGGER_NAME");
        writer.addHeaderAlias("triggerGroup", "TRIGGER_GROUP");
        writer.addHeaderAlias("cronExpression", "CRON_EXPRESSION");
        writer.addHeaderAlias("timeZoneId", "TIME_ZONE_ID");

        // 写入数据
        writer.write(dataList);

        // 关闭写入器
        writer.close();
    }
}