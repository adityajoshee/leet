package adityajoshee.threading.oddEvenSync.helpc;

/**
 * Created by aditya on 10/14/16.
 */
public class Even extends Thread{
    private static Printer p;
    static int i=2;
    int max ;

    public void run(){
        try {
            while(i<max){
                p.print(i);
                i += 2;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public Even(Printer p,int max){
        this.p = p;
        this.max=max;
    }
}