package com.company;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        String[] strings = {"1", "1", "2", "1", "3", "4", "5"};
        HashMap<String, Integer> setUniqueStrings = new HashMap<String, Integer>();
        for(String x : strings) {
            if(setUniqueStrings.get(x) == null)
                setUniqueStrings.put(x, 1);
            else
                setUniqueStrings.put(x, setUniqueStrings.get(x) + 1);
        }
        for(String x : setUniqueStrings.keySet()) {
            System.out.println(x);
        }
        for (HashMap.Entry<String, Integer> o : setUniqueStrings.entrySet()) {
            System.out.println(o.getKey() + ": " + o.getValue());
        }
        Phonebook book = new Phonebook();
        book.add("1", "123456");
        book.add("2", "123456");
        book.add("3", "123456");
        book.add("1", "654321");
        System.out.println(book.get("1"));
    }
}
