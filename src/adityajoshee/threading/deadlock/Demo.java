package adityajoshee.threading.deadlock;

/**
 * Created by adityajoshee on 23/05/16.
 */
public class Demo {

    public static void main(String args[]){
        SharedResourceA resourceA = new SharedResourceA();
        SharedResourceB resourceB = new SharedResourceB();


        /*
                 deadlock situation
                 initially threadA grabs rescA and threadB grabs rescB
                 but while processing their resources they need rescB and
                 rescA resp. But they are already locked with each other.
                 So...a deadlock.

         */
        (new Thread("A") {
            public void run() {
                resourceA.resc(resourceB);
            }
        }).start();

        (new Thread("B") {
            public void run() {
                resourceB.resc(resourceA);
            }
        }).start();

    }




}
