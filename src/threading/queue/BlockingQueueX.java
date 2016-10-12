package threading.queue;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by aditya on 8/8/16.
 */
public class BlockingQueueX {

    private List<Integer> queue = new LinkedList();
    private int  limit = 10;

    public BlockingQueueX(int limit){
        this.limit = limit;
    }


    public synchronized void enqueue(Integer item) {
        while(this.queue.size() == this.limit) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(this.queue.size() == 0) {
            notifyAll();
        }
        this.queue.add(item);
    }


    public synchronized Integer dequeue(){
        while(this.queue.size() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(this.queue.size() == this.limit){
            notifyAll();
        }

        return this.queue.remove(0);
    }

}