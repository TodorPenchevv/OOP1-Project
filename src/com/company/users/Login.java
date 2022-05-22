package com.company.users;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {
    private String usernameInput;
    private String passwordInput;
    private String username;
    private boolean admin;
    private boolean successful = false;

    public Login() throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.print("Username: ");
        usernameInput = in.nextLine();
        System.out.print("Password: ");
        passwordInput = in.nextLine();
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

    private void findUser() {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("accounts.txt"));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);

                String[] split = line.split(",");
                if(usernameInput == split[0] && passwordInput == split[1]) {
                    username = split[0];
                    if(split[2] == "admin")
                        admin = true;
                    else
                        admin = false;
                }

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
