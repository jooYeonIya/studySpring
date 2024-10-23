package com.example.jjStore;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

  public List<Product> findAll() throws SQLException {
    String sql = "select * from products";
    pstmt = conn.prepareStatement(sql);
    List<Product> products = new ArrayList<>();
    ResultSet resultSet = pstmt.executeQuery();
    while (resultSet.next()) {
      Product product = new Product(
          resultSet.getInt("id"),
          resultSet.getString("name"),
          resultSet.getInt("price"),
          resultSet.getString("maker"),
          resultSet.getInt("stock")
      );

      products.add(product);
    }
    return products;
  }

  public Product findById(String id) throws SQLException {
    String sql = "select * from products where id = ?";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, id);
    ResultSet resultSet = pstmt.executeQuery();

    while (resultSet.next()) {
      Product product = new Product(
          resultSet.getInt("id"),
          resultSet.getString("name"),
          resultSet.getInt("price"),
          resultSet.getString("maker"),
          resultSet.getInt("stock")
      );

      return product;
    }

    return null;
  }

  public void update(int id, String name, int price) throws SQLException {
    String sql = "update products set name = ?, price = ? where id = ?";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, name);
    pstmt.setInt(2, price);
    pstmt.setInt(3, id);
    pstmt.executeUpdate();
  }

  public void delete(int id) throws SQLException {
    String sql = "delete from products where id = ?";
    pstmt = conn.prepareStatement(sql);
    pstmt.setInt(1, id);
    pstmt.executeUpdate();
  }
}
