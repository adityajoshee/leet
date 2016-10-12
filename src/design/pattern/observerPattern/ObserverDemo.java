package design.pattern.observerPattern;

/**
 * Created by aditya.joshee on 20/07/15.
 */
public class ObserverDemo {
    public static void main(String args[]){
        Subject temperature = new Subject();
        temperature.addObserver(new Observer1());
        temperature.addObserver(new Observer2());
        temperature.update(34);
    }
}
