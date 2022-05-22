package com.company;

import com.company.books.Book;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<Book>();

    public Library() {
        getFileContent();
    }

    public String allBooks() {
        return "All";
    }

    public String info(String number) {
        return "Info";
    }

    public String find(String option, String optionString) {
        return "Find";
    }

    public String sort(String option) {
        return "Sort";
    }

    public String sort(String option, String optionString) {
        return "Sort";
    }

    public void add() {}

    public void remove(int number) {}

    private void getFileContent() {

    }

    public void save() {

    }
}
