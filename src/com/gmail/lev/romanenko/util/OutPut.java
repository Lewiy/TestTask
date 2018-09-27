package com.gmail.lev.romanenko.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutPut {

    private static List<String> result;
    private static String pathOutFile;

    public OutPut(List<String> result, String pathOutFile) {
        this.result = result;
        this.pathOutFile = pathOutFile;
    }

    public static void writeToFile() {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(pathOutFile));
            for (String resString : result) {
                writer.write(resString);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
            }
        }
    }

    public static void writeToConsol() {
        for (String resString : result) {
            System.out.println(resString);
        }
    }

}
