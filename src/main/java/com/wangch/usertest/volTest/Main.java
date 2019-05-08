package com.wangch.usertest.volTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static A a = new A();
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new TestThread2());
        executorService.submit(new TestThread());
        executorService.shutdown();

    }
}
