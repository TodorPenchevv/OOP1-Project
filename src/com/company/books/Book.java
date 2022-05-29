package com.company.books;

import java.io.Serializable;
import java.util.Arrays;

public class Book implements Serializable {
    private String author;
    private String title;
    private Genre genre;
    private String description;
    private int year;
    private String[] tags;
    private float rating;
    private int number;

    public Book(String author, String title, Genre genre, String description, int year, String[] tags, float rating, int number) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.year = year;
        this.tags = tags;
        this.rating = rating;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String[] getTags() {
        return tags;
    }

    public float getRating() { return rating; }

    public int getYear() { return year; }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                ", description='" + description + '\'' +
                ", year=" + year +
                ", tags=" + Arrays.toString(tags) +
                ", rating=" + rating +
                ", number=" + number +
                '}';
    }
}
