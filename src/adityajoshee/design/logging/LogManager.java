package adityajoshee.design.logging;

/**
 * Created by aditya on 12/2/16.
 */

/*
 central configuration class for the logging framework
 Stores default values for handlers, levels, filter, loggers, formatter, filenames etc.
*/

public class LogManager {

    private static final LogManager instance = new LogManager();

    private LogManager(){
        throw new UnsupportedOperationException();
    }

    public static synchronized LogManager getInstance(){
        return instance;
    }
}
