package adityajoshee.threading.queue;

/**
 * Created by aditya on 8/8/16.
 */
public class TaskPull implements Runnable {

    BlockingQueue q;
    int taskCount;

    public TaskPull(BlockingQueue q, int taskCount){
        this.q=q;
        this.taskCount=taskCount;
    }

    public void run(){
        for(int i=1; i<=taskCount; i++){
            q.dequeue(i);
            System.out.println("PULL:"+i);
            try {
                Thread.sleep(900);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
