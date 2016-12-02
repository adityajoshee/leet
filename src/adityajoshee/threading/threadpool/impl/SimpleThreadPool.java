package adityajoshee.threading.threadpool.impl;

import adityajoshee.threading.threadpool.AbstractThreadPool;
import adityajoshee.threading.threadpool.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by aditya on 8/14/16.
 */
public class SimpleThreadPool extends AbstractThreadPool{

    private int maxPoolSize;
    private boolean isLazy;
    private BlockingQueue<Task> taskQueue ;
    private int initialQueueSize;
    private int currentActiveThreads;
    private List<SimpleThread> threads = new ArrayList<>();

    public SimpleThreadPool(int maxPoolSize, boolean isLazy, int initialQueueSize){
        this.maxPoolSize = maxPoolSize;
        this.isLazy = isLazy;
        this.initialQueueSize = initialQueueSize;
        this.taskQueue = new LinkedBlockingQueue<>(initialQueueSize);
    }

    @Override
    public int getMaxPoolSize() {
        return this.maxPoolSize;
    }

    @Override
    public BlockingQueue<Task> getTaskQueue() {
        return taskQueue;
    }

    @Override
    public boolean isLazy() {
        return this.isLazy;
    }

    @Override
    public boolean shutdown() {
        for (SimpleThread t: threads)
        {
            System.out.println("Shutting Thread...");
            try{
                t.stopThread();
            }
            catch (Exception e){
                //e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public boolean initialize(int threadsToStart) {
        super.initialize();
        if(threadsToStart==0){
            return true;
        }
        // start "threadsToStart" threads
        for(int i=1; i<=threadsToStart; i++){
            SimpleThread t = new SimpleThread(taskQueue);
            t.start();
            threads.add(t);
        }
        return true;
    }

    @Override
    public boolean submit(Task task) {
        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }
}
