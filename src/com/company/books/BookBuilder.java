package com.company.books;

public class BookBuilder {
    private String author;
    private String title;
    private Genre genre;
    private String description;
    private int year;
    private String[] tags;
    private float rating;
    private int number;

    public BookBuilder withAuthor(String author) {
        this.author = author;
        return this;
    }

    public BookBuilder withTitle(String title) {
        this.title = title;
        return this;
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

    public BookBuilder withTags(String[] tags) {
        this.tags = tags;
        return this;
    }

    public BookBuilder withRating(float rating) {
        this.rating = rating;
        return this;
    }

    public BookBuilder withNumber(int number) {
        this.number = number;
        return this;
    }

    public Book build() {
        return new Book(author, title, genre, description, year, tags, rating, number);
    }
}
