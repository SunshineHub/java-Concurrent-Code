package com.wangch.usertest.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class MyRecursiveAction extends RecursiveAction {

    private int workload;

    public MyRecursiveAction(int workload) {
        this.workload = workload;
    }

    @Override
    protected void compute() {
        if(this.workload > 16){
            System.out.println("继续分任务：" + this.workload);

            List<MyRecursiveAction> subtasks = createRecursiveAction();

            subtasks.forEach(n->{
                n.fork();
            });

            subtasks.forEach(n->{
                n.join();
            });
        }else{
            System.out.println("开始做任务：" + this.workload);
            System.out.println("pia pia pia");
            try {
                Thread.sleep(60 * 60 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public List<MyRecursiveAction> createRecursiveAction(){
        List<MyRecursiveAction> subtasks =
                new ArrayList<>();
        MyRecursiveAction subtask1 = new MyRecursiveAction(this.workload / 2);
        MyRecursiveAction subtask2 = new MyRecursiveAction(this.workload / 2);
        subtasks.add(subtask1);
        subtasks.add(subtask2);
        return subtasks;
    }
}
