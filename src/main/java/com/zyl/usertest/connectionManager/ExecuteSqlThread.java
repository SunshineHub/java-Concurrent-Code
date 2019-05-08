package com.zyl.usertest.connectionManager;

public class ExecuteSqlThread extends Thread{

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.getConnection();
        ConnectionManager connectionManager2 = new ConnectionManager();
        Connection connection2 = connectionManager2.getConnection();
        System.out.println(name + " has " + connection);
        System.out.println(name + " has " + connection2);
    }
}
