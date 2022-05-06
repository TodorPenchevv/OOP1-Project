package com.company;

public class UserInput {
    private String input;

    public void getUserInput() {
        this.input = System.console().readLine();
    }

    public void readInput() {

    }

    public void help() {
        System.out.println("open     <file> opens <file>");
        System.out.println("close    closes currently opened file");
        System.out.println("save     saves the currently open file");
        System.out.println("saveas   <file> saves the currently open file in <file>");
        System.out.println("help     prints this information");
        System.out.println("exit     exists the program");
    }

    public void exit() {}
}
