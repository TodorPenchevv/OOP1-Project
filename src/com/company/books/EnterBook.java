package com.company.books;

import java.util.Scanner;

public class EnterBook {

    public static Book create() {
        BookBuilder bookBuilder = new BookBuilder();
        Scanner in = new Scanner(System.in);
        String input;

        System.out.print("Author: ");
        input = in.nextLine();
        if(input != "") {
            bookBuilder.withAuthor(input);
        }

        System.out.print("Title: ");
        input = in.nextLine();
        if(input != "") {
            bookBuilder.withTitle(input);
        }

        System.out.print("Genre: ");
        input = in.nextLine();
        if(input != "") {
            if(input.equalsIgnoreCase("Literary fiction"))
                bookBuilder.withGenre(Genre.LITERARY_FICTION);
            else if(input.equalsIgnoreCase("Mystery"))
                bookBuilder.withGenre(Genre.MYSTERY);
            else if(input.equalsIgnoreCase("Thriller"))
                bookBuilder.withGenre(Genre.THRILLER);
            else if(input.equalsIgnoreCase("Horror"))
                bookBuilder.withGenre(Genre.HORROR);
            else if(input.equalsIgnoreCase("Historical"))
                bookBuilder.withGenre(Genre.HISTORICAL);
            else if(input.equalsIgnoreCase("Romance"))
                bookBuilder.withGenre(Genre.ROMANCE);
            else if(input.equalsIgnoreCase("Western"))
                bookBuilder.withGenre(Genre.WESTERN);
            else if(input.equalsIgnoreCase("Bildungsroman"))
                bookBuilder.withGenre(Genre.BILDUNGSROMAN);
            else if(input.equalsIgnoreCase("Speculative fiction"))
                bookBuilder.withGenre(Genre.SPECULATIVE_FICTION);
            else if(input.equalsIgnoreCase("Science fiction"))
                bookBuilder.withGenre(Genre.SCIENCE_FICTION);
            else if(input.equalsIgnoreCase("Fantasy"))
                bookBuilder.withGenre(Genre.FANTASY);
            else if(input.equalsIgnoreCase("Distopian"))
                bookBuilder.withGenre(Genre.DYSTOPIAN);
            else if(input.equalsIgnoreCase("Children"))
                bookBuilder.withGenre(Genre.CHILDREN);
            else if(input.equalsIgnoreCase("Pircture book"))
                bookBuilder.withGenre(Genre.PICTURE_BOOK);
            else
                bookBuilder.withGenre(Genre.OTHER);
        }

        System.out.print("Description: ");
        input = in.nextLine();
        if(input != "") {
            bookBuilder.withDescription(input);
        }

        System.out.print("Year: ");
        input = in.nextLine();
        if(input != "") {
            bookBuilder.withYear(Integer.parseInt(input));
        }

        System.out.print("Keywords (comma separated): ");
        input = in.nextLine();
        if(input != "") {
            String[] split = input.split(",");
            bookBuilder.withKeywords(split);
        }

        System.out.print("Rating: ");
        input = in.nextLine();
        if(input != "") {
            bookBuilder.withRating(Float.parseFloat(input));
        }

        System.out.print("Number: ");
        input = in.nextLine();
        if(input != "") {
            bookBuilder.withNumber(Integer.parseInt(input));
        }

        return bookBuilder.build();
    }
}
