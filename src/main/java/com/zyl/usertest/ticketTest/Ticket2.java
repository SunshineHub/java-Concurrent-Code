package com.zyl.usertest.ticketTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket2 {

    public static int ticketCount = 100;


    static class TicketSeller extends Thread {
        static Lock lock = new ReentrantLock();
        @Override
        public void run() {
            String stateName = Thread.currentThread().getName();

            while (true){
                lock.lock();
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
                lock.unlock();
                System.out.println("state:" + stateName + " remain ticket " + ticketCount);
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
