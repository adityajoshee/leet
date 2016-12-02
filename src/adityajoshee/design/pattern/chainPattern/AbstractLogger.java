package adityajoshee.design.pattern.chainPattern;

/**
 * Created by adityajoshee on 18/05/16.
 */
public abstract class AbstractLogger {
    public static final int DEBUG = 1;
    public static final int INFO = 2;
    public static final int ERROR = 3;

    protected int level;

    public int getLevel() {
        return level;
    }

    public AbstractLogger getNext() {
        return next;
    }

    private AbstractLogger next;

    public void setNext(AbstractLogger next){
        this.next=next;
    }

    public void log(String msg, int msgLevel){
        if(level>=msgLevel){
            write(msg);
        }
        if(next!=null && next.getLevel()>=msgLevel){
            next.log(msg,msgLevel);
        }
    }

    public abstract void write(String msg);


}
