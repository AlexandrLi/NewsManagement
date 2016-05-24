package com.epam.ali.testapp.database;

public class DaoException extends Exception {
    public DaoException(String message, Exception e) {
        super(message, e);
    }
}
