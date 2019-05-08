package com.zyl.usertest.ticketTest;

public class Ticket1 {

    public static int ticketCount = 100;


    static class TicketSeller extends Thread {

        @Override
        public void run() {
            String name = Thread.currentThread().getName();

            while (true) {
                synchronized (TicketSeller.class) {
                    if(ticketCount > 0) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        ticketCount--;
                        System.out.println("name:" + name + " remain ticket " + ticketCount);
                    }else{
                        break;
                    }
                }
            }
            System.out.println(name + " get out");
        }
    }

    public static void main(String[] args) {
        TicketSeller ticketSeller1 = new TicketSeller();
        TicketSeller ticketSeller2 = new TicketSeller();
        ticketSeller1.start();
        ticketSeller2.start();

    }
}
