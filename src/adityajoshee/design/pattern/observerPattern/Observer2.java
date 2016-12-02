package adityajoshee.design.pattern.observerPattern;

/**
 * Created by aditya.joshee on 20/07/15.
 */
public class Observer2 implements Observer {
    @Override
    public void updateReceivedFromSubject() {
        System.out.println("Observer2 : Update received from subject ...");
    }
}
