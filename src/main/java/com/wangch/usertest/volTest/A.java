package com.wangch.usertest.volTest;

public class A {
    boolean flag;
    String stringFlag = "c";
    A a;

    public synchronized void testMethod(){
        String name = Thread.currentThread().getName();
        boolean bool = flag;
        String flagString = stringFlag;
        if (a.flag) {
            //System.out.println();
            System.out.println(name + " : " + flagString);
        }
    }
}
