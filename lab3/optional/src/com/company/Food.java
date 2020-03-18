package com.company;

public class Food implements Item {
    private String name;
    private double weight;

    @Override
    public String getName() {
        return name;
    }
    public Food(){};

    public Food(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getValue(){return weight*2;}
}
