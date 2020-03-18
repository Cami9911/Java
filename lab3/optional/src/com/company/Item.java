package com.company;

public interface Item extends Comparable<Item> {

    String getName();
    void setName(String name);

    double getValue();

    double getWeight();

    default double profitFactor() {
        return getValue() / getWeight();
    }

    @Override
    default int compareTo(Item i) {
        return getName().compareTo(i.getName());
    }

}

