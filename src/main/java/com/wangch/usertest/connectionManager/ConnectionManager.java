package com.wangch.usertest.connectionManager;

public class ConnectionManager {
    public static final ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    public  Connection getConnection(){
        Connection connection = threadLocal.get();
        if (connection == null) {
            Connection connection1 = new Connection();
            threadLocal.set(connection1);
            connection = connection1;
        }
        return connection;
    }
}
