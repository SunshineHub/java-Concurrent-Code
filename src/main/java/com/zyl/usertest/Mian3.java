package com.zyl.usertest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Mian3 {
    public static class Trader {
        private final String name;
        private final String city;

        public Trader(String n, String c) {
            this.name = n;
            this.city = c;
        }

        public String getName() {
            return this.name;
        }

        public String getCity() {
            return this.city;
        }

        public String toString() {
            return "Trader:" + this.name + " in " + this.city;
        }
    }

    public static class Transaction {
        private final Trader trader;
        private final int year;
        private final int value;

        public Transaction(Trader trader, int year, int value) {
            this.trader = trader;
            this.year = year;
            this.value = value;
        }


        public Trader getTrader() {
            return trader;
        }

        public int getYear() {
            return year;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "{" + this.trader + ", " +
                    "year: "+this.year+", " +
                    "value:" + this.value +"}";
        }
    }

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        List<Transaction> collect = transactions.stream().filter(t -> t.getYear() == 2011).sorted(Comparator.comparingInt(Transaction::getValue)).collect(Collectors.toList());
        System.out.println(collect);
        List<String> collect1 = transactions.stream().map(e -> e.getTrader().getCity()).distinct().collect(Collectors.toList());
        System.out.println(collect1);
        List<Trader> collect2 = transactions.stream().map(Transaction::getTrader).filter(e -> e.getCity().equals("Cambridge")).distinct().sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());
        System.out.println(collect2);
        List<String> collect3 = transactions.stream().map(e -> e.getTrader().getName()).sorted(String::compareTo).collect(Collectors.toList());
        System.out.println(collect3);
        boolean milan = transactions.stream().anyMatch(e -> e.getTrader().getCity().equals("Milan"));
        System.out.println(milan);
        transactions.stream().filter(e -> e.getTrader().getCity().equals("Cambridge")).map(Transaction::getValue)
                .forEach(System.out::println);
        Optional<Transaction> max = transactions.stream().max(Comparator.comparing(Transaction::getValue));
        System.out.println(max);
        Optional<Transaction> reduce = transactions.stream().reduce((a, b) -> a.getValue() < b.getValue() ? a : b);
        Optional<Transaction> min = transactions.stream().min(Comparator.comparing(Transaction::getValue));
        System.out.println(reduce.get());
        System.out.println(min.get());
    }
}
