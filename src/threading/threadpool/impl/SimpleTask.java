package threading.threadpool.impl;

import threading.threadpool.Task;

/**
 * Created by aditya on 8/14/16.
 */
public class SimpleTask implements Task {

    private boolean isComplete;
    private int id;
    public SimpleTask(int id){
        this.id = id;
        isComplete = false;
    }

    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public boolean execute() {
        // do something time consuming in a thread
        System.out.println("Task#"+id+" Starting.");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task#"+id+" Done.");
        return true;
    }


}
