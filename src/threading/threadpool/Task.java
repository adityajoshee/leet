package threading.threadpool;

/**
 * Created by aditya on 8/14/16.
 */
public interface Task  {

    public boolean isComplete();
    public boolean execute();

}
