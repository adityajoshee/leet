package adityajoshee.design.logging.filter;

import adityajoshee.design.logging.logger.LogRecord;

/**
 * Created by aditya on 12/2/16.
 */
public interface Filter {
    boolean isLoggable(LogRecord logRecord);
}
