package adityajoshee.threading.queue;

/**
 * Created by aditya on 8/8/16.
 */
public class Demo {
    public static void main(String args[]){
        BlockingQueue q = new BlockingQueue(10);
        TaskPut producer = new TaskPut(q,50);
        TaskPull consumer = new TaskPull(q,50);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        consumerThread.start();
        producerThread.start();

    }
}
