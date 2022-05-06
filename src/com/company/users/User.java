package com.company.users;

public class User {
    private String username = null;
    private boolean admin = false;

    public void login() throws Exception {
        Login login = new Login();
        if(login.isSuccessful()) {
            this.username = login.getUsername();
            this.admin = login.getAdmin();
        } else {
            System.out.println("Login failed!");
        }
    }

    public void logout() {
        this.username = null;
        this.admin = false;
    }

    public void addUser() {
        if (this.checkPermission()) {
            //create user
            //String username, String password, boolean admin
        }
    }

    public void removeUser() {
        if(this.checkPermission()) {
            //remove user
            //String username
        }
    }

    public void addBook() {
        if(this.checkPermission()) {
            //add new book
            //fields marked with * are mandatory
            //press enter to skip book field
        }
    }

    public void removeBook() {
        if(this.checkPermission()) {
            //remove book
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
        return (this.username == null ? false : true);
    }
}
