package org.example;

import java.util.ArrayList;

public class DataBase {
    private static final ArrayList<User> ArrayOfUsers = new ArrayList<>();

    //    Check if the user exists in the database
    public boolean IsExist(String email, String password) {
        boolean flag = false;
        for (User i : ArrayOfUsers) {
            if (i.getEmail().contains(email) && i.getPassword().contains(password)) {
                flag = true;
                break;
            }
        }
        return flag;
    }
    //    Return all users from database
    public User getUser(String email, String password) {
        User newUser = new User();
        for (User i : ArrayOfUsers) {
            if (i.getEmail().contains(email) && i.getPassword().contains(password)) {
                newUser = i;
            }
        }
        return newUser;
    }
    //    Add new user to database
    public void AddToDatabase(User newUser) {
        ArrayOfUsers.add(newUser);
    }
}