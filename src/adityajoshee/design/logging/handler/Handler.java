package adityajoshee.design.logging.handler;

import adityajoshee.design.logging.enums.Level;
import adityajoshee.design.logging.filter.Filter;
import adityajoshee.design.logging.formatter.Formatter;
import adityajoshee.design.logging.logger.LogRecord;

/**
 * Created by aditya on 12/2/16.
 */
public interface Handler {

    void setLevel(Level level);
    void setFilter(Filter filter);
    void setFormatter(Formatter formatter);
    void publish(LogRecord logRecord);
    boolean isLoggable(LogRecord logRecord);
    void configure();
}
