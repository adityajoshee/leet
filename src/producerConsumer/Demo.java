package producerConsumer;

import java.util.Vector;

/**
 * Created by aditya.joshee on 20/07/15.
 */
public class Demo {
    public static void main(String args[]){
        Vector<Integer> sharedVector=new Vector<Integer>(50);
        Thread p = new Thread(new Producer(sharedVector,50));
        Thread c1 = new Thread(new Consumer(sharedVector,50));
        Thread c2 = new Thread(new Consumer(sharedVector,50));
        c1.start();
        c2.start();
        p.start();
    }
}
