package design.pattern.chainPattern;

/**
 * Created by adityajoshee on 18/05/16.
 */
public class DebugLogger extends AbstractLogger {
    public DebugLogger(){
        level = DEBUG;
    }
    @Override
    public void write(String msg) {
        System.out.println("DEBUG"+msg);

    }
}
