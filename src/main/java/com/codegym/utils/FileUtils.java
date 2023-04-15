package com.codegym.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public List<String> readFile (String filePath){
        File file = new File(filePath);
        List<String> lines = new ArrayList<>();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line ="";
            while ((line=bufferedReader.readLine())!=null){
                lines.add(line);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
        return lines;
    }

    public void writeFile(String filePath, List<String> list) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String line : list){
                bufferedWriter.write(line+"\n");
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}