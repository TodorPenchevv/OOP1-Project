package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class File {
    private FileReader fileReader;
    private FileWriter fileWriter;
    private String content;

    public void open(String filePath) throws FileNotFoundException {
        fileReader = new FileReader(filePath);
    }

    public void close() throws IOException {
        fileReader.close();
    }

    public void save() {}

    public void saveAs(String filePath) {
        System.out.println(filePath);
    }
}
