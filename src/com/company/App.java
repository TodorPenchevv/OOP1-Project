package com.company;

import com.company.users.User;

import java.util.Scanner;

public class App {
    private String input = "";
    private User user = User.getInstance();
    private File file = new File();
    private Library library = new Library();

    public void start() throws Exception {
        while(true) {
            Scanner in = new Scanner(System.in);
            input = in.nextLine();
            readInput();
        }
    }

    public void readInput() throws Exception {
        String[] split = input.split(" ");
        switch(split[0]) {
            case "open":
                file.open(split[1]);
                break;
            case "close":
                file.close();
                break;
            case "save":
                file.save();
                break;
            case "saveas":
                file.saveAs(split[1]);
                break;
            case "help":
                help();
                break;
            case "login":
                user.login();
                break;
            case "logout":
                if(user.isLoggedIn())
                    user.logout();
                break;
            case "books":
                switch(split[1]) {
                    case "all":
                        if(user.isLoggedIn())
                            library.allBooks();
                        break;
                    case "info":
                        if(user.isLoggedIn())
                            library.info(split[2]);
                        break;
                    case "find":
                        if(user.isLoggedIn())
                            library.find(split[2], split[3]);
                        break;
                    case "sort":
                        if(user.isLoggedIn()) {
                            if (split.length == 3)
                                library.sort(split[2]);
                            else
                                library.sort(split[2], split[3]);
                        }
                        break;
                    case "add":
                        if(user.isLoggedIn() && user.isAdmin())
                            library.add();
                        break;
                    case "remove":
                        if(user.isLoggedIn() && user.isAdmin())
                            library.remove(Integer.parseInt(split[1]));
                        break;
                }
                break;
            case "users":
                switch(split[1]) {
                    case "add":
                        user.add(split[2], split[3]);
                        break;
                    case "remove":
                        user.remove(split[2]);
                        break;
                }
                break;
            case "exit":
                library.save();
                System.exit(0);
            default:
                System.out.println("No such command!");
                System.out.println("Type \"help\" to check command options!");
                break;
        }
    }

    public void help() {
        System.out.println("The following commands are supported:");
        System.out.println("open <file>    opens <file>");
        System.out.println("close          closes currently opened file");
        System.out.println("save           saves the currently open file");
        System.out.println("saveas <file>  saves the currently open file in <file>");
        System.out.println("help           prints this information");
        System.out.println("exit           exists the program");
        System.out.println("login                                    log with your credentials");
        System.out.println("logout                                   exit from your account");
        System.out.println("books all                                prints list of all books");
        System.out.println("books info <isbn_value>                  finds book by number");
        System.out.println("books find <option> <option_string>      finds book by optional parameters");
        System.out.println("books sort <option> [asc | desc]         prints sorted list of books");
        System.out.println("books add                                adds new book");
        System.out.println("books remove <number>                    removes a book by its number");
        System.out.println("user add <user> <password>               creates new user");
        System.out.println("user remove <user>                       removes a user");
    }
}
