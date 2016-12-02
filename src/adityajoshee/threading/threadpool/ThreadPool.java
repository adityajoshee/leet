package adityajoshee.threading.threadpool;

import java.util.Queue;

/**
 * Created by aditya on 8/14/16.
 */
public interface ThreadPool<T extends Task> {

    public int getMaxPoolSize();

    public Queue<T> getTaskQueue();

    public boolean isLazy();

    public boolean shutdown();

    public boolean initialize(int threadsToStart);

    public boolean submit(T task);

}
