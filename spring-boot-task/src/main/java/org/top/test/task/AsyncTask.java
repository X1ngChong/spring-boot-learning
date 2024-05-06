package org.top.test.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncTask extends AbstractTask {

    @Async
    @Override
    public void doTaskOne() throws InterruptedException {
        super.doTaskOne();
    }
    @Async
    @Override
    public void doTaskTwo() throws InterruptedException {
        super.doTaskTwo();
    }
    @Async
    @Override
    public void doTaskThree() throws InterruptedException {
        super.doTaskThree();
    }
}
