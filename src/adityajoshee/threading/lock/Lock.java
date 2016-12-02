package adityajoshee.threading.lock;

/**
 * Created by aditya on 8/8/16.
 */
public class Lock {

    private static boolean isLocked = false;

    public synchronized void getLock(){
        while(isLocked){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
    }

    public synchronized void releaseLock(){
        if(isLocked){
            notify();
        }
        isLocked = false;
    }
}
