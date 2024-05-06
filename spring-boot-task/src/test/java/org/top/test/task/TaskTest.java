package org.top.test.task;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskTest {

    @Resource
    private SyncTask syncTask;

    @Test
    void testSyncTask() throws InterruptedException {
        syncTask.doTaskOne();
        syncTask.doTaskTwo();
        syncTask.doTaskThree();
    }
}