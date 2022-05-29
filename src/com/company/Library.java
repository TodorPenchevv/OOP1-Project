package com.company;

import com.company.books.Book;
import com.company.books.BookSort;
import com.company.books.EnterBook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<Book>();

    public Library() throws Exception {
        loadDataFromFile();
    }

    public void allBooks() {
        for(Book book : books) {
            System.out.println(book.toString());
        }
    }

    public void info(String number) {
        int intNumber = Integer.parseInt(number);
        boolean found = false;

        for(Book book : books) {
            if(book.getNumber() == intNumber) {
                System.out.println(book.toString());
                found = true;
            }
        }

        if(!found)
            System.out.println("No book found with this number!");
    }

    public void find(String option, String[] optionString) {
        boolean match = false;
        int count = 0;
        String search = "";

        for(int i = 3; i < optionString.length; i++) {
            search += optionString[i] + " ";
        }

        search = search.trim();

        for(Book book : books) {
            match = false;

            if(option.equals("title") && book.getTitle().contains(search))
                match = true;
            else if(option.equals("author") && book.getAuthor().contains(search))
                match = true;
            else if(option.equals("tag")) {
                for(String tag : book.getTags()) {
                    if(tag.equals(search))
                        match = true;
                }
            }

            if(match) {
                System.out.println(book.toString());
                count++;
            }
        }

        if(count == 0)
            System.out.println("No books matched your search!");
    }

    public void sort(String option) {
        new BookSort(books, option, "asc").sort();
    }

    public void sort(String option, String optionString) {
        new BookSort(books, option, optionString).sort();
    }

    public void add() throws Exception {
        Book newBook = EnterBook.create();
        books.add(newBook);
        System.out.println("Book successfully added!");
        saveDataToFile();
    }

    public void remove(String number) throws Exception {
        int intNumber = Integer.parseInt(number);

        books.removeIf(book -> book.getNumber() == intNumber);

        /*for(Book book : books) {
            if(book.getNumber() == intNumber)
                books.remove(book);
        }*/

        saveDataToFile();
    }

    private void loadDataFromFile() throws Exception {
        try {
            FileInputStream istream = new FileInputStream(getLibraryFile());
            if(istream.available() != 0) {
                ObjectInputStream in = new ObjectInputStream(istream);
                books = (ArrayList<Book>) in.readObject();
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveDataToFile() throws Exception {
        try {

            FileOutputStream ostream = new FileOutputStream(getLibraryFile());
            ObjectOutputStream out = new ObjectOutputStream(ostream);
            out.writeObject(books);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private java.io.File getLibraryFile() throws IOException {
        java.io.File file = new java.io.File("C:\\Users\\Todor\\Desktop\\library.txt");
        file.createNewFile();
        return file;
    }
}
