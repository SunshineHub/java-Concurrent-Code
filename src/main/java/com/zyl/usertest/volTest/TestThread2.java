package com.zyl.usertest.volTest;

public class TestThread2 extends Thread {

    @Override
    public void run() {
        while(true) {
            if(Main.a.a != null && Main.a.a.flag) {
                Main.a.testMethod();
                break;
            }
        }
    }
}
