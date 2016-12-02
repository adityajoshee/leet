package adityajoshee.design.pattern.observerPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aditya.joshee on 20/07/15.
 */
public class Subject implements Observable {

    private int state;

    private List<Observer> observerList=new ArrayList<Observer>();

    public List<Observer> getObservableList() {
        return observerList;
    }

    public List<Observer> addObserver(Observer observer){
        if(observerList!=null){
            observerList.add(observer);
        }
        return observerList;
    }

    public void notifyObservers(){
        if(observerList!=null){
            for(Observer observer:observerList){
                observer.updateReceivedFromSubject();
            }
        }
    }

    public void update(int newState){
        this.state=newState;
        notifyObservers();
    }
}
