package design.elevator.entity.interfaces;


import design.elevator.entity.DoorStatus;
import design.elevator.entity.Person;
import design.elevator.entity.Status;
import design.elevator.exceptions.MaxWeightBreachedException;

import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by aditya on 8/9/16.
 */
public interface IElevator {

    // Interfaces are meant to be stateless. They only enforce a contract on the actual implementation.
    // So ideally they should not be have any variables except for contants.

    public void goUp();

    public void goDown();

    public List<Integer> addDestination(int floor);

    public List<Integer> popDestination();

    public Set<Person> addPerson(Person person) throws MaxWeightBreachedException;

    public Status getStatus();

    public DoorStatus getDoorStatus();

}
