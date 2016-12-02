package adityajoshee.threading.queue;

/**
 * Created by aditya on 8/8/16.
 */
public class TaskPut implements Runnable {

    BlockingQueue q;
    int taskCount;

    public TaskPut(BlockingQueue q, int taskCount){
        this.q=q;
        this.taskCount=taskCount;
    }

    public void run(){
        for(int i=1; i<=taskCount; i++){
            q.enqueue(i);
            System.out.println("PUT:"+i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
