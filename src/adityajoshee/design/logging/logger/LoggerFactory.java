package adityajoshee.design.logging.logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aditya on 12/2/16.
 */
public class LoggerFactory {

    private static LoggerFactory instance = new LoggerFactory();
    private Map<String, Logger> mapNameVsLogger = new HashMap<>();

    private LoggerFactory(){
        throw new UnsupportedOperationException();
    }

    public static synchronized LoggerFactory getInstance(){
        return instance;
    }

    public Logger getLogger(String name){
        Logger logger = mapNameVsLogger.get(name);
        if (logger!=null){
            return logger;
        }
        return null;
    }


}
