package adityajoshee.design.logging.filter;

import adityajoshee.design.logging.logger.LogRecord;

/**
 * Created by aditya on 12/2/16.
 */
public class ImpMsgFilter implements Filter {
    @Override
    public boolean isLoggable(LogRecord logRecord) {
        return logRecord.getMessage().startsWith("IMPORTANT");
    }
}
