package com.epam.ali.testapp.database;

import com.epam.ali.testapp.model.News;
import org.joda.time.DateTime;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsDAO implements INewsDAO {
    public Connection getConnection() throws DaoException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "Alexandr_Li",
                    "root");
            connection.setAutoCommit(true);
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            throw new DaoException("Couldn't get connection with db", e);
        }
    }

    @Override
    public List<News> getList() throws DaoException {
        List<News> newsList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM ALEXANDR_LI.NEWS")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                News news = new News();
                news.setId(rs.getInt("news_id"));
                news.setTitle(rs.getString("news_title"));
                news.setDate(new DateTime(rs.getDate("news_date").getTime()));
                news.setBrief(rs.getString("news_brief"));
                news.setContent(rs.getString("news_content"));
                newsList.add(news);
            }
            return newsList;
        } catch (SQLException e) {
            throw new DaoException("Could not get news list from db", e);
        }
    }

    @Override
    public void save(News newsMessage) throws DaoException {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO NEWS (NEWS_TITLE, NEWS_BRIEF, NEWS_CONTENT) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, newsMessage.getTitle());
            ps.setString(2, newsMessage.getBrief());
            ps.setString(3, newsMessage.getContent());
            ps.executeUpdate();
//            ResultSet generatedKeys = ps.getGeneratedKeys();
//            generatedKeys.next();
//            newsMessage.setId(generatedKeys.getInt(1));
        } catch (SQLException e) {
            throw new DaoException("Could not update news message", e);
        }
    }

    @Override
    public void remove(Integer id) throws DaoException {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("DELETE FROM ALEXANDR_LI.NEWS WHERE NEWS_ID=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Could not remove news message from db", e);
        }
    }


    @Override
    public News fetchById(Integer id) throws DaoException {
        News newsMessage = new News();
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM ALEXANDR_LI.NEWS WHERE NEWS_ID=?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                newsMessage.setId(rs.getInt("news_id"));
                newsMessage.setTitle(rs.getString("news_title"));
                newsMessage.setDate(new DateTime(rs.getDate("news_date").getTime()));
                newsMessage.setBrief(rs.getString("news_brief"));
                newsMessage.setContent(rs.getString("news_content"));
            }
            return newsMessage;
        } catch (SQLException e) {
            throw new DaoException("Could not get news message from db", e);
        }
    }

    @Override
    public void update(News newsMessage) throws DaoException {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("UPDATE ALEXANDR_LI.NEWS SET NEWS_TITLE=?,NEWS_DATE=?,NEWS_BRIEF=?,NEWS_CONTENT=? WHERE NEWS_ID=?")) {
            ps.setString(1, newsMessage.getTitle());
            ps.setDate(2, new Date(newsMessage.getDate().getMillis()));
            ps.setString(3, newsMessage.getBrief());
            ps.setString(4, newsMessage.getContent());
            ps.setInt(5, newsMessage.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Could not update news message", e);
        }
    }
}
