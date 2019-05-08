package com.wangch.usertest.ticketTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Ticket3 {

    public static AtomicInteger ticketCount = new AtomicInteger(100);


    static class TicketSeller extends Thread {

        @Override
        public void run() {
            String stateName = Thread.currentThread().getName();

            while (ticketCount.decrementAndGet() > 0){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("state:" + stateName + " remain ticket " + ticketCount.get());
            }

        }
    }

    public static void main(String[] args) {
        TicketSeller ticketSeller1 = new TicketSeller();
        TicketSeller ticketSeller2 = new TicketSeller();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(ticketSeller1);
        executorService.submit(ticketSeller2);

    }
}
