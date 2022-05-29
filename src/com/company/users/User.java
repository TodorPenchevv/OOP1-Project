package com.company.users;

import com.company.File;

public class User {
    private static User instance = new User();
    private String username = null;
    private boolean admin = false;

    private User() {}

    public static User getInstance() { return instance; }

    public void login() throws Exception {
        if(username == null) {
            Login login = new Login();
            if (login.isSuccessful()) {
                this.username = login.getUsername();
                this.admin = login.getAdmin();
                System.out.println("Welcome, " + username + "!");
            } else {
                System.out.println("Login failed!");
            }
        } else {
            System.out.println("You are already logged in!");
        }
    }

    public void logout() {
        this.username = null;
        this.admin = false;
    }

    public void add(String username, String password) throws Exception {
        if(checkPermission()) {
            File file = new File();
            file.open("C:\\Users\\Todor\\Desktop\\users.txt");

            String fileContent = file.getContent();
            fileContent = fileContent + username + "," + password + ",0" + "\n";
            file.setContent(fileContent);

            file.save();
            file.close();
            System.out.println("New user successfully added");
        }
    }

    public void remove(String username) throws Exception {
        if(checkPermission()) {
            File file = new File();
            file.open("users.txt");

            String fileContent = file.getContent();
            String[] rows = fileContent.split("\n");
            for(int i = 0; i < rows.length; i++) {
                String[] values = rows[i].split(",");
                if(username == values[0])
                    fileContent.replace(rows[i], "");
            }
            file.setContent(fileContent);

            file.save();
            file.close();
        }
    }

    public boolean checkPermission() {
        if(!admin) {
            System.out.println("You don't have permission to use this command!");
            return false;
        }
        return true;
    }

    public boolean isLoggedIn() {
        if(username == null) {
            System.out.println("You must be logged in to use this command!");
            return false;
        }
        return true;
    }
}
