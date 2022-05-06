package com.company.books;

public class BookBuilder {
    private String author;
    private String title;
    private Genre genre;
    private String description;
    private int year;
    private String[] keywords;
    private float rating;
    private int number;

    public BookBuilder(String author, String title, int number) {
        this.author = author;
        this.title = title;
        this.number = number;
    }

    public BookBuilder withGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    public BookBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public BookBuilder withYear(int year) {
        this.year = year;
        return this;
    }

    public BookBuilder withKeywords(String[] keywords) {
        this.keywords = keywords;
        return this;
    }

    public BookBuilder withRating(float rating) {
        this.rating = rating;
        return this;
    }

    public Book build() {
        return new Book();
    }
}
