package com.company.books;

import java.util.Arrays;

public class Book {
    private String author;
    private String title;
    private Genre genre;
    private String description;
    private int year;
    private String[] keywords;
    private float rating;
    private int number;

    public Book(String author, String title, Genre genre, String description, int year, String[] keywords, float rating, int number) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.year = year;
        this.keywords = keywords;
        this.rating = rating;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                ", description='" + description + '\'' +
                ", year=" + year +
                ", keywords=" + Arrays.toString(keywords) +
                ", rating=" + rating +
                ", number=" + number +
                '}';
    }
}
