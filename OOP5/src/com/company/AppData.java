package com.company;

import java.util.Arrays;

public class AppData {
    private String[] header;
    private int[][] data = new int[0][];

    public void saveHeader(String[] header){
        this.header = header;
    }

    public void saveData(int[][] data){
        this.data = data;
    }

    public void addData(int[] data){
        this.data = addElement(this.data, data );
    }

    static int[][] addElement(int[][] a, int[] e) {
        a  = Arrays.copyOf(a, a.length + 1);
        a[a.length - 1] = e;
        return a;
    }

    public String[] getHeader(){
        return header;
    }

    public int[][] getData(){
        return data;
    }
}
