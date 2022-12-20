package com.db;

import com.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBase {
    private static final HashMap<String, User> USER = new HashMap<>();

    private DataBase() {
    }

    public static boolean create(User user) {
        if (USER.get(user.getLogin()) != null) return false;
        USER.put(user.getLogin(), user);
        return true;
    }

    public static User readUser(String login) {
        return USER.get(login);
    }

    public static List<User> getAllUsers() {
        return new ArrayList<>(USER.values());
    }
}
