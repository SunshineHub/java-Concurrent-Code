package com.wangch.usertest.servletTest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    static class DispatcherThread extends Thread {

        private HttpServlet httpServlet;
        private Map<String, Object> params;

        public DispatcherThread(Map<String, Object> params, HttpServlet servlet){
            this.httpServlet = servlet;
            this.params = params;
        }

        @Override
        public void run() {
            HttpServletRequest req = new HttpReq(this.params);
            try {
                ((MyServlet)httpServlet).doGet(req, new HttpRes());
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        HttpServlet myServlet = new MyServlet();
        for(int i = 0;i < 10;i++){
            //simulate new http request come in
            Map<String, Object> params = new HashMap<>();
            params.put("username", "wangch");
            params.put("password", "123456");
            executorService.execute(new DispatcherThread(params, myServlet));
        }
        executorService.shutdown();

        if(!executorService.awaitTermination(20 * 1000, TimeUnit.MILLISECONDS)){
            // 超时的时候向线程池中所有的线程发出中断(interrupted)。
            executorService.shutdownNow();
        }
        System.out.println("final PV:" + ((MyServlet) myServlet).getPv());
        executorService.shutdown();
    }

}
