package com.company;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    public ArrayList<T> fruit_box;

    public Box(ArrayList<T> item) {
        fruit_box = item;
    }

    public float getWeight() {
        return fruit_box.size() * fruit_box.get(0).weight;
    }

    public boolean compare(Box compare_box) {
        return this.getWeight() == compare_box.getWeight();
    }

    public void Add(T item) {
        fruit_box.add(item);
    }

    public void transport_fruits(Box<T> compare_box){
        if (compare_box.getClass().getName() == this.fruit_box.getClass().getName())
            for (T item: compare_box.fruit_box) {
                this.fruit_box.add(item);
            }
    }
}