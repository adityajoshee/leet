package threading.threadpool;

/**
 * Created by aditya on 8/14/16.
 */
public abstract class AbstractThreadPool implements ThreadPool<Task> {

    public boolean initialize(){
        System.out.println("Initializing thread pool ...");
        return true;
    }

}
