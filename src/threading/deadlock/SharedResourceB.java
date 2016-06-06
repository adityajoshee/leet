package threading.deadlock;

/**
 * Created by adityajoshee on 23/05/16.
 */
public class SharedResourceB {
    public synchronized void resc(SharedResourceA resourceA){
        System.out.println("Thread accessed SharedResourceB:"+Thread.currentThread().getName());
        try {
            Thread.sleep(500L);
            // now resc A is needed but that is with other thread..
            resourceA.resc(null);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
