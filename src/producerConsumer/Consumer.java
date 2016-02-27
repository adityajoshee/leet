package producerConsumer;

import java.util.Vector;

/**
 * Created by aditya.joshee on 20/07/15.
 */
public class Consumer implements Runnable {

    private Vector<Integer> sharedVector;
    private int size;

    public Consumer(Vector<Integer> sharedVector,int size){
        this.sharedVector=sharedVector;
        this.size=size;
    }

    private void consume(){
        System.out.println("Consuming...");
        try{
            Thread.sleep(100L);
        }
        catch (InterruptedException e)
        {
            System.out.println("Exception ...!!");
        }
        synchronized (sharedVector) {
            sharedVector.removeElementAt(0);
            //sharedVector.notify();
        }
    }

    @Override
    public void run() {
        while (true) {
            if (sharedVector.isEmpty()) {
                synchronized (sharedVector) {
                    try {
                        sharedVector.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Error occurred...");
                    }
                }
            }
            consume();

        }
    }
}
