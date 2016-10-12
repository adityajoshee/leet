package design.elevator.exceptions;

/**
 * Created by aditya on 8/10/16.
 */
public class MaxWeightBreachedException extends Exception {

    public MaxWeightBreachedException(){
        super("Maximum weight breached. Some person/persons must exit!");
    }
}
