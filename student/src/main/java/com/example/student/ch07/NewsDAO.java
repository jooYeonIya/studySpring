package com.example.student.ch07;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsDAO {
  final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
  final String JDBC_URL = "jdbc:mysql://localhost:3307/backend?serverTimezone=Asia/Seoul";

  Connection conn = null;
  PreparedStatement ps = null;

  public Connection getConn() {
    try {
      Class.forName(JDBC_DRIVER);
      conn = DriverManager.getConnection(JDBC_URL, "root", "1111");
    } catch (ClassNotFoundException | SQLException e) {
      throw new RuntimeException(e);
    }

    return conn;
  }

  public void close() {
    try {
      conn.close();
      ps.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public List<News> findAll() {
    List<News> newsList = new ArrayList<>();

    try {
      getConn();
      String sql = "select aid, title, img, content, date_format(date, '%Y-%m-%d %h:%m:%s') as cdate from news";
      ps = conn.prepareStatement(sql);
      ResultSet resultSet = ps.executeQuery();
      while (resultSet.next()) {
        News news = new News(
            resultSet.getInt(1),
            resultSet.getString(2),
            resultSet.getString(3),
            resultSet.getString(4),
            resultSet.getString(5)
        );

        newsList.add(news);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      close();
    }

    return newsList;
  }
}
