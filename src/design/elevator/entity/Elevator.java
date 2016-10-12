package design.elevator.entity;

import com.sun.jmx.remote.internal.ArrayQueue;
import design.elevator.entity.interfaces.IElevator;
import design.elevator.exceptions.MaxWeightBreachedException;

import java.util.*;

/**
 * Created by aditya on 8/9/16.
 */
public class Elevator implements IElevator{

    private static final int CAPACITY = 500;  // Max weight allowed, doesn't vary across elevators
    private int id;
    private int currentWeight = 0;      // Current persons' total weight
    private int currentFloor = 0;
    private int maxFloor;
    private List<Integer> destinationList = Collections.synchronizedList(new LinkedList<Integer>());
    private Status status = Status.REST;
    private DoorStatus doorStatus = DoorStatus.CLOSED;
    private Set<Person> personsBoarded = new HashSet<>();

    public Elevator(){

    }

    public Elevator(int id, int maxFloor) {
        this.maxFloor = maxFloor;
        this.id = id;
    }


    @Override
    public void goUp() {

    }

    @Override
    public void goDown() {

    }

    @Override
    public List<Integer> addDestination(int floor) {
        destinationList.add(floor);
        return destinationList;
    }

    @Override
    public List<Integer> popDestination() {
        return null;
    }

    @Override
    public Set<Person> addPerson(Person person) throws MaxWeightBreachedException{
        if(currentWeight+person.getWeight()<=CAPACITY){
            personsBoarded.add(person);
            return personsBoarded;
        }
        throw new MaxWeightBreachedException();
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public DoorStatus getDoorStatus() {
        return doorStatus;
    }
}
