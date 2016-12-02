package adityajoshee.threading.deadlock;

/**
 * Created by adityajoshee on 23/05/16.
 */
public class SharedResourceA {

    public synchronized void resc(SharedResourceB resourceB){
        System.out.println("Thread accessed SharedResourceA:"+Thread.currentThread().getName());
        try {
            Thread.sleep(500L);
            // now resc B is needed but that is with other thread..
            resourceB.resc(null);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
