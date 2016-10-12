package threading.semaphore;

/**
 * Created by aditya on 8/7/16.
 */
public class Demo {

    public static void main(String args[]){
        Semaphore semaphore = new Semaphore();

        for(int i=1; i<=10; i++){
            Task task = new Task(semaphore,i);
            Thread t = new Thread(task);
            System.out.println("Starting task : "+ i);
            t.start();
        }

    }
}
