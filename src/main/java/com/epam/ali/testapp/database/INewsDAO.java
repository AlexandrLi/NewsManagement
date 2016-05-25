package com.epam.ali.testapp.database;

import com.epam.ali.testapp.model.News;

import java.util.List;

public interface INewsDAO {
    List<News> getList() throws DaoException;

    void save(News newsMessage) throws DaoException;

    void remove(Integer id) throws DaoException;

    News fetchById(Integer id) throws DaoException;

    void update(News newsMessage) throws DaoException;

}
