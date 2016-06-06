package chainPattern;

/**
 * Created by adityajoshee on 18/05/16.
 */
public class InfoLogger extends AbstractLogger {

    public InfoLogger(){
        level = INFO;
    }

    @Override
    public void write(String msg) {
        System.out.println("INFO:"+msg);
    }
}
