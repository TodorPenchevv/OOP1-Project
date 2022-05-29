package com.company.books;

import java.util.List;

public class BookSort {
    private List<Book> books;
    private String column;
    private String direction;

    public BookSort(List<Book> books, String column, String direction) {
        this.books = books;
        this.column = column;
        this.direction = direction;
    }

    public void sort() {
        insertionSort(books, books.size());

        for(Book book : books) {
            System.out.println(book.toString());
        }
    }

    private void insertionSort(List<Book> books, int n)
    {
        if (n <= 1) { //passes are done
            return;
        }

        insertionSort( books, n-1 ); //one element sorted, sort the remaining array

        Book last = books.get(n-1); //last element of the array
        int j = n-2;  //correct index of last element of the array

        while (j >= 0 && getCondition(books.get(j), last)) //find the correct index of the last element
        {
            books.set(j+1, books.get(j)); //shift section of sorted elements upwards by one element if correct index isn't found
            j--;
        }

        books.set(j+1, last); //set the last element at its correct index
    }

    private boolean getCondition(Book book1, Book book2) {
        int result;
        if(column.equals("title")) {
            result = book1.getTitle().compareTo(book2.getTitle());
            if((direction.equals("asc") && result > 0)
                || (direction.equals("desc") && result < 0))
                return true;
            return false;
        }
        if(column.equals("author")) {
            result = book1.getAuthor().compareTo(book2.getAuthor());
            if((direction.equals("asc") && result > 0)
                || (direction.equals("desc") && result < 0))
                return true;
            return false;
        }
        if(column.equals("year")) {
            if((direction.equals("asc") && book1.getYear() > book2.getYear())
                || (direction.equals("desc") && book1.getYear() < book2.getYear()))
                return true;
            return false;
        }
        if(column.equals("rating")) {
            if((direction.equals("asc") && book1.getRating() > book2.getRating())
                || (direction.equals("desc") && book1.getRating() < book2.getRating()))
                return true;
            return false;
        }
        return false;
    }
}
