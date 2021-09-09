package com.company;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<Apple>();
        apples.add(new Apple());
        apples.add(new Apple());
        apples.add(new Apple());
        apples.add(new Apple());
        apples.add(new Apple());
        apples.add(new Apple());
        apples.add(new Apple());
        apples.add(new Apple());

        ArrayList<Orange> oranges = new ArrayList<Orange>();
        oranges.add(new Orange());
        oranges.add(new Orange());
        oranges.add(new Orange());
        oranges.add(new Orange());

        Box apple_box = new Box(apples);
        Box orange_box = new Box(oranges);
        System.out.println(apple_box.compare(orange_box));
    }

    public void array_method(Object[] array, int index1, int index2){
        Object temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
