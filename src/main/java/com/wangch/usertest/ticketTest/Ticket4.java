package com.wangch.usertest.ticketTest;

import java.util.concurrent.Semaphore;

public class Ticket4 {

    public static int ticketCount = 100;

    static class TicketSeller extends Thread {
        static Semaphore semaphore = new Semaphore(1);
        @Override
        public void run() {
            String stateName = Thread.currentThread().getName();
            try {

                while (true) {
                    semaphore.acquire();
                    if(ticketCount > 0) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        ticketCount--;
                    }else{
                        break;
                    }
                    semaphore.release();
                    System.out.println("name:" + stateName + " remain ticket " + ticketCount);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TicketSeller ticketSeller1 = new TicketSeller();
        TicketSeller ticketSeller2 = new TicketSeller();
        ticketSeller1.start();
        ticketSeller2.start();

    }
}
