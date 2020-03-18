package com.company;

import java.util.ArrayList;
import java.util.List;

public class Greedy implements Algorithm {
    Knapsack knap;
    ArrayList<Item> items;

    public Greedy(Knapsack knap, List<Item> items) {
        this.knap = knap;
        this.items = (ArrayList<Item>) items;
    }

    void sortItems(ArrayList<Item> items, Knapsack knap) {
        Item aux;
        for (int i = 0; i < items.size(); i++) {
            for (int j = i + 1; j < items.size(); j++) {
                if (items.get(i).getValue() < items.get(j).getValue()) {
                    aux = items.get(i);
                    items.set(i, items.get(j));
                    items.set(j, aux);

                }
            }
        }
    }


    @Override
    public void solveProblem() {
        sortItems(items,knap);
        for (int i = 0; i <items.size() ; i++) {
            knap.addItem(items.get(i));
        }
        knap.printKnap();
    }
}
