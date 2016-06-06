package chainPattern;

/**
 * Created by aditya.joshee on 20/07/15.
 */

// chain of responsibility pattern
public class ChainPatternDemo {

    public static void main(String args[]){
        DebugLogger debugLogger = new DebugLogger();
        InfoLogger infoLogger = new InfoLogger();
        ErrorLogger errorLogger = new ErrorLogger();
        errorLogger.setNext(infoLogger);
        infoLogger.setNext(debugLogger);
        errorLogger.log("aditya",2);

    }

}
