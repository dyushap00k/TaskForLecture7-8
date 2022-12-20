package com.service;

public class CredentialService {
    private CredentialService(){}
    public static boolean isValidName(String name) {
        return name != null && !name.isBlank() && !name.contains(" ");
    }

    public static boolean isValidLogin(String login) {
        return login != null && login.length() >= 6 && !login.isBlank() && !login.contains(" ");
    }

    public static boolean isValidPassword(String password) {
        return password != null && password.length() >= 8 && !password.isBlank() && !password.contains(" ");
    }
}
