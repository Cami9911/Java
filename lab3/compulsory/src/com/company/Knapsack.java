package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Knapsack {
    private double capacity;
    private double availableCapacity;
    private double totalValue;
    private TreeSet<Item> items = new TreeSet<>();


    public Knapsack(double capacity) {
        this.capacity = capacity;
        this.availableCapacity = capacity;
        this.totalValue=0;
    }

    public double getAvailableCapacity() {
        return availableCapacity;
    }

    public void setAvailableCapacity(double availableCapacity) {
        this.availableCapacity = availableCapacity;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public TreeSet<Item> getItems() {
        return items;
    }

    public void setItems(TreeSet<Item> items) {
        double totalWeight = 0;
        double totalValue=0;
        for (Item x : items) {
            totalWeight += x.getWeight();
            totalValue += x.getValue();
        }
        if (capacity < totalWeight)
            System.out.println("Capacitate insuficienta");
        else {
            this.items = items;
            availableCapacity -= totalWeight;
            this.totalValue=totalValue;
        }
    }

    public void addItem(Item item) {
        if (availableCapacity >= item.getWeight()) {
            items.add(item);
            this.totalValue+=item.getValue();
            availableCapacity = availableCapacity - item.getWeight();
        } else {
            System.out.println("Capacitate ghiozdanului " + availableCapacity + " este prea mica pentru " + item.getWeight());
        }

    }

    public double getTotalValue() {
        return totalValue;
    }

    public double calcTotalWeight() {
        return capacity - availableCapacity;
    }
}
