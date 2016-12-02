package adityajoshee.design.logging.logger;

import adityajoshee.design.logging.enums.Level;

import java.io.Serializable;

/**
 * Created by aditya on 12/2/16.
 */
public class LogRecord implements Serializable{
    private String message;
    private Long timeInMillis;
    private String loggerName;
    private Level level;

    public LogRecord(String message, Long timeInMillis, String loggerName, Level level) {
        this.message = message;
        this.timeInMillis = timeInMillis;
        this.loggerName = loggerName;
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimeInMillis() {
        return timeInMillis;
    }

    public void setTimeInMillis(Long timeInMillis) {
        this.timeInMillis = timeInMillis;
    }

    public String getLoggerName() {
        return loggerName;
    }

    public void setLoggerName(String loggerName) {
        this.loggerName = loggerName;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
