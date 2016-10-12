package threading.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by aditya on 8/8/16.
 */
public class BlockingQueue {

    Queue<Integer> q;
    int capacity ;

    public BlockingQueue(int capacity){
        this.capacity=capacity;
        q = new LinkedList<>();
    }

    public synchronized void enqueue(Integer x){
        if(q.size()==capacity){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(q.size()==0){
            notifyAll();
        }
        System.out.println("Enqueue:"+x);
        q.add(x);
    }

    public synchronized Integer dequeue(int pullNumber){
        if(q.size()==0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Dequeue:"+pullNumber);

        if(q.size()==capacity){
            notifyAll();
        }
        return q.poll();
    }

}
