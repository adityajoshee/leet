package threading.oddEvenSync;

/**
 * Created by adityajoshee on 22/05/16.
 */
public class PrintSpoolerOddEven implements IPrinter {


    /*
    print(int k) must be sync such that it must print
    odd and even sequentially by 2 threads;
     */

    public synchronized void print(int k){

        System.out.print(k+"  ");
        try{
            notify();
            wait();
        }
        catch (InterruptedException e){
            System.err.print("error...");
        }
    }

}
