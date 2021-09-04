package com.company;

public class Main {

    public static void main(String[] args) {
        String[][] correct = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        String[][] incorrect = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        String[][] incorrect2 = {
                {"1", "2", "3", "4"},
                {"1", "2", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        String[][] incorrect3 = {
                {"1", "2", "3", "4"},
                {"1", "a", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        try{
            ArrayProcedure(incorrect3);
        }catch (MyArrayDataException ex){
            ex.printStackTrace();
        }catch (MyArraySizeException ex){
            ex.printStackTrace();
        }
    }

    public static void ArrayProcedure(String[][] my_array) throws MyArraySizeException, MyArrayDataException{
        if(my_array.length != 4) throw new MyArraySizeException();
        int sum = 0;
        for(int i = 0; i < my_array.length; i++) {
            if(my_array[i].length != 4) throw new MyArraySizeException();
            for (int j = 0; j < my_array.length; j++) {
                try {
                    sum += Integer.parseInt(my_array[i][j]);
                } catch (NumberFormatException ex){
                    System.out.println(ex.getMessage());
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        System.out.println("Sum= " + sum);
    }
}

class MyArraySizeException extends Exception {
    public MyArraySizeException() {
        super("Wrong array size!");
    }
}

class MyArrayDataException extends Exception {
    public MyArrayDataException(int i, int j) {
        super("Error at (" + i + ", " + j + ")");
    }
}

