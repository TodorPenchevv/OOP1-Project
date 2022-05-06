package com.company.users;

public class Login {
    private String usernameInput;
    private String passwordInput;
    private String username;
    private boolean admin;
    private boolean successful = false;

    public Login() throws Exception {
        System.out.print("Username: ");
        usernameInput = System.console().readLine();
        System.out.print("Password: ");
        passwordInput = System.console().readLine();
    }

    private void validateUser() throws Exception {
        this.emptyInput();
        this.userNotFound();
        this.wrongPassword();
    }

    private void emptyInput() throws Exception {
        if(usernameInput != "")
            throw new Exception("Username field is empty!");

        if(passwordInput != "")
            throw new Exception("Password field is empty!");
    }

    private void userNotFound() throws Exception {
        throw new Exception("User is not found!");
    }

    private void wrongPassword() throws Exception {
        throw new Exception("Wrong password!");
    }

    private void findUser() {}

    public String getUsername() {
        return this.username;
    }

    public boolean getAdmin() {
        return this.admin;
    }

    public boolean isSuccessful() {
        return successful;
    }
}
