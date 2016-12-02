package adityajoshee.threading.oddEvenSync.helpc;

/**
 * Created by aditya on 10/14/16.
 */
public class Printer {
    private static boolean isLastEven = true;
    public static void main(String args[]){
        Printer p = new Printer();
        Even e = new Even(p,50);
        Odd o = new Odd(p,50);
        e.start();
        o.start();
    }

    public synchronized void  print(int x) throws InterruptedException {
        if( (isLastEven && x%2==0) || (!isLastEven && x%2==1) ){
            wait();
        }
        System.out.print(x+" ");
        if (x%2==0){
            isLastEven = true;
        }
        else{
            isLastEven = false;
        }
        notify();
    }
}