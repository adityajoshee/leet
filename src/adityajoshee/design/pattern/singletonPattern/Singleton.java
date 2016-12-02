package adityajoshee.design.pattern.singletonPattern;

/**
 * Created by aditya.joshee on 20/07/15.
 */
public class Singleton {

    private static Singleton instance;

    private Singleton() throws Exception {
        throw new Exception();
    }

    public static Singleton getInstance() throws Exception{
        if(instance!=null){
            return instance;
        }
        synchronized (Singleton.class){
            if(instance!=null){
                instance=new Singleton();
            }
            return instance;
        }
    }

}
