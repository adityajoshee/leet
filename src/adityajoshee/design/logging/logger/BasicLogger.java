package adityajoshee.design.logging.logger;

import adityajoshee.design.logging.enums.Level;
import adityajoshee.design.logging.filter.Filter;
import adityajoshee.design.logging.handler.Handler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aditya on 12/3/16.
 */
public class BasicLogger implements Logger {
    private List<Handler> handlers;
    private Filter filter;
    private Level level;

    @Override
    public void log(Level level, String msg) {
        log(new LogRecord(msg, System.currentTimeMillis(),getClass().getName(),level));
    }

    @Override
    public void log(LogRecord logRecord) {
        for (Handler hld: handlers) {
            hld.publish(logRecord);
        }
    }

    @Override
    public void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public String getName() {
        return getClass().getName();
    }

    @Override
    public void addHandler(Handler handler) {
        if (handlers==null){
            handlers = new ArrayList<>();
        }
        handlers.add(handler);
    }

    @Override
    public void setFilter(Filter filter) {
        this.filter = filter;
    }

}
