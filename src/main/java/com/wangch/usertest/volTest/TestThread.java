package com.wangch.usertest.volTest;

public class TestThread extends Thread {

    @Override
    public void run() {
        Main.a.a = new A();
        Main.a.a.flag = true;
        Main.a.testMethod();
    }
}
