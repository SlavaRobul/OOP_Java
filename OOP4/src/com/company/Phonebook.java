package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Phonebook {
    private HashMap<String, LinkedList<String>> book = new HashMap<>();
    public void Phonebook(){};
    public void add(String name, String phone){
        if(book.get(name) == null)
            book.put(name, new LinkedList<String>(Arrays.asList(phone)));
        else {
            LinkedList<String> tempList = book.get(name);
            tempList.add(phone);
            book.put(name,tempList);
        }
    }

    public LinkedList<String> get(String name){
        if(book.get(name) == null)
            return null;
        else {
            return book.get(name);
        }
    }
}
