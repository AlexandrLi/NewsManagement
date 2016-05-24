package com.epam.ali.testapp;

import com.epam.ali.testapp.database.DaoException;
import com.epam.ali.testapp.database.NewsDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Runner {
    public static void main(String[] args) throws DaoException {
        NewsDAO newsDAO = new NewsDAO();
        Connection connection = newsDAO.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeQuery("INSERT INTO ALEXANDR_LI.NEWS(NEWS_TITLE, NEWS_BRIEF, NEWS_CONTENT) VALUES ('Test Test Test Test Test','TestB TestB TestB TestB TestB TestB TestB TestB TestB TestB TestB','TestC TestC TestC TestC TestC TestC TestC TestC TestC TestC TestC TestC TestC TestC TestC TestC')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
