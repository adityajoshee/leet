package com.booking.entities;

/**
 * Created by adityajoshee on 22/05/16.
 */
public class Passenger {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Passenger(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

