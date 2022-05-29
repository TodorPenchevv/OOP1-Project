package com.company;

import java.io.*;

public class File {
    private boolean fileOpened =  false;
    private String filePath;
    private String content;

    public void open(String path) throws Exception {
        filePath = path;
        content = readFileContent();
        fileOpened = true;
    }

    public void close() {
        if(fileOpened()) {
            content = null;
            filePath = null;
            fileOpened = false;
        }
    }

    public void save() throws Exception {
        if(fileOpened())
            writeFileContent(filePath);
    }

    public void save(String newPath) throws Exception {
        if(fileOpened())
            writeFileContent(newPath);
    }

    private String readFileContent() throws Exception {
        java.io.File file = new java.io.File(filePath);
        file.createNewFile();

        BufferedReader buffReader = new BufferedReader(new FileReader(filePath));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;

        while ((line = buffReader.readLine()) != null) {
            stringBuilder.append(line).append("\n");
        }

        buffReader.close();

        return stringBuilder.toString();
    }

    private void writeFileContent(String path) throws Exception {
        FileWriter wr = new FileWriter(path);
        wr.write(content);
        wr.flush();
        wr.close();
    }

    private boolean fileOpened() {
        if(!fileOpened)
            System.out.println("No file currently opened!");
        return fileOpened;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
