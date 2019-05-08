package com.zyl.usertest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class Mian {
    static class Apple{
        Integer weight;

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "weight=" + weight +
                    '}';
        }
    }
    public static void main(String[] args) {
        List<Apple> list = new ArrayList<>();
        Apple apple = new Apple();
        Apple apple2 = new Apple();
        apple.setWeight(1);
        apple2.setWeight(2);
        list.add(apple);
        list.add(apple2);
        list.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
        System.out.println(list);
        list.sort(Comparator.comparingInt(a -> a.getWeight()));
        System.out.println(list);
        list.sort(Comparator.comparingInt(Apple::getWeight));
        System.out.println(list);

        Function<String, Integer> f = (s) -> Integer.parseInt(s);
        //1.指向静态方法
        Function<String, Integer> f2 = Integer::parseInt;
        Function<String, Integer> c = String::length;
        System.out.println(c.apply("hahacc"));
        BiFunction<String, Integer, String> f3 = (str, i) -> str.substring(i);
        //2.任意类型的实例方法
        BiFunction<String, Integer, String> f4 = String::substring;
        String s = new String();
        Consumer<Integer> c3 = (i) -> s.substring(i);
        //3.指向现有对象的实例方法
        Consumer<Integer> c2 = s::substring;
    }
}
