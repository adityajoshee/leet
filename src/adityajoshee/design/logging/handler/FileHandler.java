package adityajoshee.design.logging.handler;

import adityajoshee.design.logging.LogManager;
import adityajoshee.design.logging.enums.Level;
import adityajoshee.design.logging.filter.Filter;
import adityajoshee.design.logging.formatter.Formatter;
import adityajoshee.design.logging.logger.LogRecord;

/**
 * Created by aditya on 12/2/16.
 */
public class FileHandler implements Handler {

    LogManager logManager = LogManager.getInstance();

    public FileHandler(){
        configure();
    }

    @Override
    public void setLevel(Level level) {

    }

    @Override
    public void setFilter(Filter filter) {

    }

    @Override
    public void setFormatter(Formatter formatter) {

    }

    @Override
    public void publish(LogRecord logRecord) {

    }

    @Override
    public boolean isLoggable(LogRecord logRecord) {
        return false;
    }

    @Override
    public void configure() {

    }
}
