package com.company.users;

import com.company.File;

import java.io.Console;
import java.util.Scanner;

public class Login {
    private String usernameInput;
    private String passwordInput;
    private String username;
    private boolean admin;
    private boolean wrongPassword;
    private boolean successful = false;

    public Login() throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.print("Username: ");
        usernameInput = in.nextLine();

        System.out.print("Password: ");
        passwordInput = in.nextLine();

        findUser();
    }

    private void findUser() throws Exception {
        if(!emptyInput()) {
            File file = new File();
            file.open("C:\\Users\\Todor\\Desktop\\users.txt");

            checkUsersFile(file);

            String[] rows = file.getContent().split("\n");

            for(int i = 0; i < rows.length; i++) {
                String[] values = rows[i].split(",");
                if (usernameInput.equals(values[0]) && passwordInput.equals(values[1])) {
                    username = values[0];
                    if (values[2].equals("1"))
                        admin = true;
                    else
                        admin = false;

                    successful = true;
                } else if (usernameInput.equals(values[0]) && !passwordInput.equals(values[1])) {
                    wrongPassword = true;
                    break;
                }
            }

            wrongPassword();
            userNotFound();

            file.close();
        }
    }

    private boolean emptyInput() {
        if(usernameInput.equals("")) {
            System.out.println("Username field is empty!");
            return true;
        }

        if(passwordInput.equals("")) {
            System.out.println("Password field is empty!");
            return true;
        }

        return false;
    }

    private void userNotFound() {
        if(username == null)
            System.out.println("User is not found!");
    }

    private void wrongPassword() {
        if(wrongPassword)
            System.out.println("Wrong password!");
    }

    private void checkUsersFile(File file) throws Exception {
        if(file.getContent().equals("")) {
            file.setContent("admin,i<3c++,1\n");
            file.save();
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
