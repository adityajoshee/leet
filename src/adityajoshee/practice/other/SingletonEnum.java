package adityajoshee.practice.other;

/**
 * Created by aditya.joshee on 23/11/14.
 */
public enum SingletonEnum {
    INSTANCE;

    private int id;

    public synchronized void setId(int id){
        INSTANCE.id=id;
    }

    public static void main(String args[]){
        INSTANCE.setId(1);
    }

}
