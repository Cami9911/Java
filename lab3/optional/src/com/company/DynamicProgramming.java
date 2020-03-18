package com.company;

import java.util.List;

public class DynamicProgramming implements Algorithm{
    Knapsack knap;
    List<Item> items;

    public DynamicProgramming(Knapsack knap, List<Item> items) {
        this.knap = knap;
        this.items = items;
    }

    @Override
    public void solveProblem() {

    }
}
