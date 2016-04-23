package threading;

/**
 * Created by adityajoshee on 21/04/16.
 */
public class OddEven {

    public static void main(String args[]){
        Printer p = new Printer();        // sync resource
        Thread t1 = new Thread(new OddThread(p,20)); // pass the same printer resource to both
        Thread t2 = new Thread(new EvenThread(p,20));
        t2.start();

        t1.start();
    }

    static class OddThread implements Runnable{
        private Printer p;
        private int k ;
        public OddThread(){}
        public OddThread(Printer p,int n){this.p=p;k=n;}

        public void run(){
            int c=1;
            while(c<=k){
                p.printOdd(c);
                c=c+2;
            }
        }
    }

    static class EvenThread implements Runnable{
        private Printer p;
        private int k ;
        public EvenThread(){}
        public EvenThread(Printer p,int n){this.p=p;k=n;}

        public void run(){
            int c=0;
            while(c<=k){
                p.printEven(c);
                c=c+2;
            }
        }
    }

    static class Printer{
        private boolean lastOddPrint=true; // needed for sequential printing of numbers

        public synchronized void printOdd(int n)   {
            if(lastOddPrint){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(n);
            lastOddPrint=true;
            notify();

        }

        public synchronized void printEven(int n)   {
            if(!lastOddPrint){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(n);
            lastOddPrint=false;
            notify();

        }
    }

}
