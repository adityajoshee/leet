package adityajoshee.design.logging.formatter;

import adityajoshee.design.logging.logger.LogRecord;

/**
 * Created by aditya on 12/2/16.
 */
public interface Formatter {

    String format(LogRecord logRecord);
}
