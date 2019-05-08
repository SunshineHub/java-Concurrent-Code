package com.wangch.usertest.servletTest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyServlet extends HttpServlet {

    private int pv = 0;
    private Map<String, Object> map = new ConcurrentHashMap<>();

    public int getPv() {
        return pv;
    }

    @Override
    public synchronized void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(!map.containsKey("1")){
            System.out.println("put 1");
            map.put("1", "1");
        }

        System.out.println("login " + username + "," + password);
        int a = pv + 1;
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pv = a;
        System.out.println("pv:" + pv);
    }
}
