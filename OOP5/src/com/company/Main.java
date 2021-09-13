package com.company;

public class Main {

    public static void main(String[] args) {
        CSVReader reader = new CSVReader();
        AppData tempData = reader.readFromCSV("C:\\OOP_Java\\OOP5\\src\\com\\company\\test.csv");
        System.out.println(tempData.getHeader()[1]);
    }
}
