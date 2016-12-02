package adityajoshee.design.elevator.entity;

/**
 * Created by aditya on 8/9/16.
 */
public class Person {
    int id;
    int weight;

    public Person(int id, int weight){
        this.id=id;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
