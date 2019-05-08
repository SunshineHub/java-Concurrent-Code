package com.zyl.usertest.connectionManager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new ExecuteSqlThread());
        executorService.submit(new ExecuteSqlThread());
        executorService.shutdown();
        System.out.println("main run out");
    }
}
