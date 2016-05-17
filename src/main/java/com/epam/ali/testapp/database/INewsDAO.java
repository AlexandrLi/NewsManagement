package com.epam.ali.testapp.database;

import com.epam.ali.testapp.model.News;

import java.util.List;

public interface INewsDAO {
    List<News> getList();

    void save();

    void remove();

    void fetchById(Integer id);

}
