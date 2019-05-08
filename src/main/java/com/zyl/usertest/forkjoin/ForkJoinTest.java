package com.zyl.usertest.forkjoin;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ForkJoinTest {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> collect = IntStream.range(0, 5000000).boxed().collect(Collectors.toList());
        long before = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        MyRecursiveAction myRecursiveAction = new MyRecursiveAction(32);
        System.out.println(collect);
        MyRecursiveTask myRecursiveTask = new MyRecursiveTask(collect);
        //forkJoinPool.invoke(myRecursiveAction);
        Integer invoke = forkJoinPool.invoke(myRecursiveTask);
        System.out.println("merge results : " + invoke);
        System.out.println("cost : " + (System.currentTimeMillis() - before) + "ms");

        /*long before2 = System.currentTimeMillis();
        int sum = collect.stream().mapToInt(n -> n.intValue()).sum();
        System.out.println("second results: " + sum);
        System.out.println("cost2 : " + (System.currentTimeMillis() - before2) + "ms");*/
    }
}
