package adityajoshee.design.logging.formatter;

import adityajoshee.design.logging.logger.LogRecord;

/**
 * Created by aditya on 12/2/16.
 */
public class XMLFormatter implements Formatter {
    @Override
    public String format(LogRecord logRecord) {
        return logRecord.getMessage();
    }
}
