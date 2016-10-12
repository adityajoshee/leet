package design.pattern.chainPattern;

/**
 * Created by adityajoshee on 18/05/16.
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(){
        level = ERROR;
    }

    @Override
    public void write(String msg) {
        System.out.println("ERROR:"+msg);
    }
}
