package org.top.test.task;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AsyncTaskTest {

    @Resource
    private AsyncTask asyncTask;

    @Test
    void testSyncTask() throws InterruptedException {
        asyncTask.doTaskOne();
        asyncTask.doTaskTwo();
        asyncTask.doTaskThree();
    }

}