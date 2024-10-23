package com.example.jjStore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDAO {
  final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
  final String JDBC_URL = "jdbc:mysql://localhost:3307/backend?serverTimezone=Asia/Seoul";

  Connection conn = null;
  PreparedStatement pstmt = null;

  public void open() {
    try {
      Class.forName(JDBC_DRIVER);
      conn = DriverManager.getConnection(JDBC_URL, "root", "1111");
    } catch (ClassNotFoundException | SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void close() {
     try {
      conn.close();
      pstmt.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void insert(Product product) throws SQLException {
    String sql = "insert products(name, price, maker, stock) values(?, ?, ?, ?)";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, product.getName());
    pstmt.setInt(2, product.getPrice());
    pstmt.setString(3, product.getMaker());
    pstmt.setInt(4, product.getStock());

    int result = pstmt.executeUpdate();

    if (result> 0) {
      System.out.println("success");
    } else {
      System.out.println("error");
    }
  }
}
