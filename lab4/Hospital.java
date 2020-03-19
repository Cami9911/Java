package com.company;

public class Hospital implements Comparable<Hospital>{
    private String name;
    private int capacity;

    public Hospital(String name, int capacity) {
        this.name = name;
        this.capacity=capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int compareTo(Hospital o) {
        if(this.getName().compareTo(o.getName())!=0)
            return this.getName().compareTo(o.getName());
        return this.getCapacity()-o.getCapacity();
    }
}
