package design.pattern.observerPattern;

/**
 * Created by aditya.joshee on 20/07/15.
 */
public class Observer1 implements Observer {


    @Override
    public void updateReceivedFromSubject() {
        System.out.println("Observer1 : Update received from subject ...");
    }
}
