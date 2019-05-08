package com.zyl.usertest.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Integer> {

    private long workLoad;
    private List<Integer> sums;
    private static final int THRESHOLD = 1000;

    public MyRecursiveTask(List<Integer> sums) {
        this.workLoad = sums.size();
        this.sums = sums;
    }

    protected Integer compute() {

        //if work is above threshold, break tasks up into smaller tasks
        if(this.workLoad > THRESHOLD) {
            System.out.println("Splitting workLoad : " + this.workLoad);

            List<MyRecursiveTask> subtasks =
                    new ArrayList<MyRecursiveTask>();
            subtasks.addAll(createSubtasks(sums));

            for(MyRecursiveTask subtask : subtasks){
                subtask.fork();
            }

            Integer result = 0;
            for(MyRecursiveTask subtask : subtasks) {
                result += subtask.join();
            }
            return result;

        } else {
            System.out.println("Doing workLoad myself: " + this.workLoad);
            return this.sums.stream().mapToInt(i -> i.intValue()).sum();
        }
    }

    private List<MyRecursiveTask> createSubtasks(List<Integer> sums) {
        List<MyRecursiveTask> subtasks =
                new ArrayList<MyRecursiveTask>();

        MyRecursiveTask subtask1 = new MyRecursiveTask(sums.subList(0, sums.size() / 2));
        MyRecursiveTask subtask2 = new MyRecursiveTask(sums.subList(sums.size() / 2, sums.size()));

        subtasks.add(subtask1);
        subtasks.add(subtask2);

        return subtasks;
    }
}