package adityajoshee.threading.threadpool;

import adityajoshee.threading.threadpool.impl.SimpleTask;
import adityajoshee.threading.threadpool.impl.SimpleThreadPool;

/**
 * Created by aditya on 8/14/16.
 */
public class DemoThreadPool {

    public static void main(String args[]){
        ThreadPool threadPool = new SimpleThreadPool(100, true, 10);
        threadPool.initialize(10);

        long start = System.currentTimeMillis();

        for(int i=1; i<=100; i++){
            Task task = new SimpleTask(i);
            threadPool.submit(task);
        }

        long end = System.currentTimeMillis();

        System.out.println(end-start); // time taken to submit all tasks...

        // wait for queue to become empty
        while(threadPool.getTaskQueue().size()>0){
        }

        // Wait for threads to finish final tasks...
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // shutdown...
        threadPool.shutdown();


    }
}
