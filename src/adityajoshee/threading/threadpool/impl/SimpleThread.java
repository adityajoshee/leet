package adityajoshee.threading.threadpool.impl;

import adityajoshee.threading.threadpool.Task;

import java.util.concurrent.BlockingQueue;

/**
 * Created by aditya on 8/14/16.
 */
public class SimpleThread extends Thread {

    private BlockingQueue<Task> queue ;
    private boolean isStopped = false;

    public SimpleThread(BlockingQueue queue){
        this.queue = queue;
    }

    public void run(){
        while(!isStopped){
            try {
                queue.take().execute();
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }
    }

    public void stopThread(){
        this.isStopped = true;
        this.interrupt();
    }
}
