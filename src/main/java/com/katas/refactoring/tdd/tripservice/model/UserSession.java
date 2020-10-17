package com.katas.refactoring.tdd.tripservice.model;

public class UserSession {

    private static UserSession instance;

    private UserSession() {

    }

    static {
        instance = new UserSession();
    }

    public static UserSession getInstance() {
        return instance;
    }

    public User getLoggedUser() {
        return null;
    }
}
