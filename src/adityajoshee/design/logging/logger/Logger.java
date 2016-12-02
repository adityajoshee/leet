package adityajoshee.design.logging.logger;


import adityajoshee.design.logging.enums.Level;
import adityajoshee.design.logging.filter.Filter;
import adityajoshee.design.logging.handler.Handler;

/**
 * Created by aditya on 12/2/16.
 */
public interface Logger {

    void log(Level level, String msg);
    void setLevel(Level level);
    String getName();
    void addHandler(Handler handler);
    void setFilter(Filter filter);
    void log(LogRecord logRecord);
}
