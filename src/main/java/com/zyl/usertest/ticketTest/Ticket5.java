package com.zyl.usertest.ticketTest;

public class Ticket5 {

    private static int ticketCount = 100;
    public static final ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return ticketCount;
        }
    };

    static class TicketSeller extends Thread {

        @Override
        public void run() {
            String stateName = Thread.currentThread().getName();

            while (true) {
                Integer count = threadLocal.get();
                if(count > 0) {
                    threadLocal.set(count - 1);
                    System.out.println("name:" + stateName + " remain ticket " + count);
                }else{
                    break;
                }
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
