package com.company;

import com.company.users.User;

import java.util.Scanner;

public class App {
    private String input = "";
    private User user = User.getInstance();
    private File file = new File();
    private Library library = new Library();

    public App() throws Exception {}

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
                if (enoughArguments(2, split))
                    file.open(split[1]);
                break;
            case "close":
                file.close();
                break;
            case "save":
                file.save();
                break;
            case "saveas":
                if (enoughArguments(2, split))
                    file.save(split[1]);
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
                if(enoughArguments(2, split)) {
                    switch(split[1]) {
                        case "all":
                            if(user.isLoggedIn())
                                library.allBooks();
                            break;
                        case "info":
                            if(user.isLoggedIn() && enoughArguments(3, split))
                                library.info(split[2]);
                            break;
                        case "find":
                            if(user.isLoggedIn() && enoughArguments(3, split))
                                library.find(split[2], split);
                            break;
                        case "sort":
                            if(user.isLoggedIn() && enoughArguments(3, split)) {
                                if (split.length == 3)
                                    library.sort(split[2]);
                                else
                                    library.sort(split[2], split[3]);
                            }
                            break;
                        case "add":
                            if(user.isLoggedIn() && user.checkPermission())
                                library.add();
                            break;
                        case "remove":
                            if(user.isLoggedIn() && user.checkPermission() && enoughArguments(3, split))
                                library.remove(split[2]);
                            break;
                        default:
                            wrongCommand();
                            break;
                    }
                }
                break;
            case "users":
                if (enoughArguments(2, split)) {
                    switch (split[1]) {
                        case "add":
                            if (enoughArguments(4, split))
                                user.add(split[2], split[3]);
                            break;
                        case "remove":
                            if (enoughArguments(3, split))
                                user.remove(split[2]);
                            break;
                        default:
                            wrongCommand();
                            break;
                    }
                }
                break;
            case "exit":
                System.out.println("Exiting the program...");
                System.exit(0);
            default:
                wrongCommand();
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
        System.out.println("users add <user> <password>              creates new user");
        System.out.println("users remove <user>                      removes a user");
    }

    public void wrongCommand() {
        System.out.println("No such command!");
        helpMessage();
    }

    public boolean enoughArguments(int count, String[] split) {
        if(split.length < count) {
            System.out.println("Not enough arguments!");
            helpMessage();
            return false;
        }
        return true;
    }

    public void helpMessage() {
        System.out.println("Type \"help\" to check command options!");
    }
}
