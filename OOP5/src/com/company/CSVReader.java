package com.company;

import java.io.*;
import java.util.Arrays;

public class CSVReader {

    public void writeInCSV(AppData data){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new File("test.csv"));
            StringBuilder sb = new StringBuilder();
            sb.append(String.join(";", data.getHeader()));
            sb.append('\n');
            for (int[] x: data.getData()) {
                sb.append(String.join(";", Arrays.toString(x).split("[\\[\\]]")[1].split(", ")));
                sb.append('\n');
            }
            writer.write(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public AppData readFromCSV(String path) {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        AppData data = new AppData();
        try {
            br = new BufferedReader(new FileReader(path));
            boolean key = true;
            while ((line = br.readLine()) != null) {
                if (key) {
                    data.saveHeader(line.split(cvsSplitBy));
                    key = false;
                } else {
                    data.addData(Arrays.stream(line.split(cvsSplitBy)).mapToInt(Integer::parseInt).toArray());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return data;
    }
}

