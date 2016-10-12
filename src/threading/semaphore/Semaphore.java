package threading.semaphore;

/**
 * Created by aditya on 8/7/16.
 */
public class Semaphore{

    private static int consumed = 0;
    private static int MAX_COUNT = 3;

    public Semaphore(int max){
        MAX_COUNT = max;
    }
    public Semaphore(){}

    public static int getConsumed() {
        return consumed;
    }

    public synchronized void getResource(int level) {
        while(consumed==MAX_COUNT) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        consumed++;
        System.out.println("Consume. Consumed:"+consumed+", Task:"+level);
    }

    public synchronized void releaseResource(int level) {
        if(consumed ==0){
            System.out.println("No resc to release!");
        }
        else{
            consumed--;
            System.out.println("Release. Consumed:"+consumed+", Task:"+level);
            notify();
        }
    }
}
