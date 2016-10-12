package threading.semaphore;

/**
 * Created by aditya on 8/7/16.
 */
public class Task implements Runnable {

    Semaphore s;
    int level ;

    public Task(Semaphore s, int level){
        this.s = s;
        this.level=level;
    }

    public void run(){
        s.getResource(level);
        try {
            Thread.sleep(1000*level);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        s.releaseResource(level);
    }
}
