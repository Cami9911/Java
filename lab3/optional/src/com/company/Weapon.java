package com.company;

import com.company.Item;

public class Weapon implements Item {
    private WeaponType type;
    private double weight;
    private double value;

    @Override
    public double getWeight(){
        return weight;
    }
    public Weapon(){};

    @Override
    public String getName(){
        return type.name();
    }
    public enum WeaponType{Sword,Knife,Pan;}

    public Weapon(WeaponType type, double weight, double value) {
        this.type = type;
        this.weight = weight;
        this.value = value;
    }

    public WeaponType getType() {
        return type;
    }

    public void setName(String name) { }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
