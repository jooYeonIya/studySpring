package com.example.student.ch16;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
  final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
  final String JDBC_URL = "jdbc:mysql://localhost:3307/backend?serverTimezone=Asia/Seoul";

  Connection conn = null;

  PreparedStatement pstmt = null;

  public void open() {
    try {
      Class.forName(JDBC_DRIVER);
      conn = DriverManager.getConnection(JDBC_URL, "root", "1111");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void close() {
    try {
      pstmt.close();
      conn.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void insert(Student s) throws SQLException {
    String sql = "insert into student(name, univ, birth, email) values(?,?,?,?)";

    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, s.getName());
    pstmt.setString(2, s.getUniv());
    pstmt.setDate(3, new java.sql.Date(s.getBirth().getTime()));
    pstmt.setString(4, s.getEmail());
    pstmt.executeUpdate();
  }

  public List<Student> findAll() throws SQLException {
    String sql = "select * from student";
    pstmt = conn.prepareStatement(sql);
    ResultSet rs = pstmt.executeQuery();
    List<Student> students = new ArrayList<>();

    while (rs.next()) {
      Student s = new Student(
          rs.getInt("id"),
          rs.getString("name"),
          rs.getString("univ"),
          rs.getString("email"),
          rs.getDate("birth")
      );

      students.add(s);
    }

    return students;
  }

  public Student findById(String id) throws SQLException {
    String sql = "select * from student where id = ?";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, id);
    ResultSet resultSet = pstmt.executeQuery();

    if (resultSet.next()) {
      Student s = new Student(
          resultSet.getInt("id"),
          resultSet.getString("name"),
          resultSet.getString("univ"),
          resultSet.getString("email"),
          resultSet.getDate("birth")
      );
      return s;
    } else {
      return null;
    }
  }
}
