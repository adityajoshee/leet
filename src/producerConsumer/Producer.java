package producerConsumer;

import java.util.Vector;

/**
 * Created by aditya.joshee on 20/07/15.
 */
public class Producer implements Runnable {

    private Vector<Integer> sharedVector;
    private int size;

    public Producer(Vector<Integer> sharedVector,int size){
        this.sharedVector=sharedVector;
        this.size=size;
    }

    private void produce(){
        System.out.println("Producing...");
        try {
            Thread.sleep(1000L);
        }catch (InterruptedException e){
            System.out.println("Exception ...!!");
        }
        synchronized (sharedVector){
            sharedVector.add(1);
            sharedVector.notify();
        }
    }

    @Override
    public void run() {
        while (true) {
            if (sharedVector.size() == size) {
                synchronized (sharedVector) {
                    try {
                        System.out.println("Producer waiting....");
                        sharedVector.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Exception occurred ...");
                    }
                }
            }
            produce();
        }
    }
}
