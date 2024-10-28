package org.example.spring_sample.student.repository;

import org.example.spring_sample.student.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepositoryMysqImpl implements StudentRepository {
  final DataSource dataSource;

  @Autowired
  public StudentRepositoryMysqImpl(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public List<Student> findALl() throws SQLException {
    Connection conn = getConnection();
    String sql = "select * from student";
    PreparedStatement ps = conn.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    List<Student> students = new ArrayList<>();
    while (rs.next()) {
      Student student = new Student(
          rs.getInt("id"),
          rs.getString("name"),
          rs.getString("email"),
          rs.getString("univ"),
          rs.getString("birth")
      );

      students.add(student);
    }

    return students;
  }

  @Override
  public Student findById(int id) {
    return null;
  }

  @Override
  public void update(Student student) {

  }

  @Override
  public int add(Student student) {
    return 0;
  }

  @Override
  public void delete(int id) {

  }

  private Connection getConnection() {
    return DataSourceUtils.getConnection(dataSource);
  }
}
