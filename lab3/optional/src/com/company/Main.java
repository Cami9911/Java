package com.company;

import java.util.ArrayList;

public class Main {
    void printItems(ArrayList<Item> items, Knapsack knapsack) {
        System.out.println("capacity of the knapsack: " + knapsack.getCapacity());
        System.out.println("available items: ");
        for (Item x : items) {
            System.out.println("    " + x.getName() + ", weight=" + x.getWeight() + ", value=" + x.getValue() + " (profit factor=" + x.profitFactor() + ")");
        }

        System.out.print("selected items: ");
        int contor = 0;

        for (Item x : knapsack.getItems()) {
            contor++;
            if (contor == knapsack.getItems().size())
                System.out.print(x.getName()+" ");
            else
                System.out.print(x.getName() + ", ");
        }
        System.out.println("(total weight= " + knapsack.calcTotalWeight() + ", total value= " + knapsack.getTotalValue() + ")");
    }

    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<Item>();

        Knapsack knapsack = new Knapsack(10);

        Item book1 = new Book("Dragon Rising", 300, 5);
        Item book2 = new Book("A Blade in the Dark", 300, 5);

        Item food1 = new Food("Cabbage", 2);
        Item food2 = new Food("Rabbit", 2);

        Item weapon = new Weapon(Weapon.WeaponType.Sword, 5, 10);


        items.add(book1);
        items.add(book2);
        items.add(food1);
        items.add(food2);
        items.add(weapon);

        Algorithm alg = new Greedy(knapsack,items);
        alg.solveProblem();



    }
}
