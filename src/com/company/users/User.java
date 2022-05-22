package com.company.users;

public class User {
    private static User instance = new User();
    private String username = null;
    private boolean admin = false;

    private User() {}

    public static User getInstance() {
        return instance;
    }

    public void login() throws Exception {
        if(username == null) {
            Login login = new Login();
            if (login.isSuccessful()) {
                this.username = login.getUsername();
                this.admin = login.getAdmin();
            } else {
                System.out.println("Login failed!");
            }
        } else {
            System.out.println("There is logged in user already!");
        }
    }

    public void logout() {
        this.username = null;
        this.admin = false;
    }

    public void add(String username, String password) {
        if (this.checkPermission()) {
            //create user
            //String username, String password, boolean admin
        }
    }

    public void remove(String username) {
        if(this.checkPermission()) {
            //remove user
            //String username
        }
    }

    public boolean checkPermission() {
        if(!this.admin) {
            System.out.println("You don't have permission to use this command!");
            return false;
        }
        return true;
    }

    public boolean isAdmin() {
        return admin;
    }

    public boolean isLoggedIn() {
        if(this.username == null) {
            System.out.println("You must be logged in to use this command!");
            return false;
        }
        return true;
    }
}
