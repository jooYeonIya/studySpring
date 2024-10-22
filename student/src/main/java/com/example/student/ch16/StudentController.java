package com.example.student.ch16;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/students")
public class StudentController extends HttpServlet {

  StudentDAO service;

  @Override
  public void init(ServletConfig config) throws ServletException {
    service = new StudentDAO();
    service.open();
  }

  @Override
  public void destroy() {
    // service.close();
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String action = req.getParameter("action");
    String method = req.getMethod();
    String path = "/ch06/";
    String view = "";

    if (action == null) {
      resp.sendRedirect("/students?action=list");
    } else {
      switch (action) {
        case "list":
          try {
            view = list(req, resp);
            req.getRequestDispatcher(path + view).forward(req, resp);
          } catch (SQLException e) {
            throw new RuntimeException(e);
          }
          break;

        case "info":
          try {
            view = info(req, resp);
            req.getRequestDispatcher(path + view).forward(req, resp);
          } catch (SQLException e) {
            throw new RuntimeException(e);
          }
          break;

        case "update":
          view = update(req, resp);
          break;

        case "delete":
          try {
            view = delete(req, resp);
            resp.sendRedirect(view);
          } catch (SQLException e) {
            throw new RuntimeException(e);
          }
          break;

        case "insert":
          try {
            view = insert(req, resp);

            if (method.equals("GET")) {
              req.getRequestDispatcher(path + view).forward(req, resp);
            } else {
              resp.sendRedirect(view);
            }
          } catch (SQLException e) {
            throw new RuntimeException(e);
          }
          break;
      }
    }
  }

  public String info(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
    String id = req.getParameter("id");
    Student s = service.findById(id);
    req.setAttribute("student", s);
    return "studentInfo.jsp";
  }

  public String update(HttpServletRequest req, HttpServletResponse resp) {
    return "";
  }

  public String delete(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
    service.delete(req.getParameter("id"));
    return "/students?action=list";
  }

  public String list(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
    List<Student> students = service.findAll();
    req.setAttribute("students", students);
    return "studentList.jsp";
  }

  public String insert(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
    String method = req.getMethod();

    if (method.equals("POST")) {
      Student s = new Student(
          req.getParameter("name"),
          req.getParameter("univ"),
          req.getParameter("email"),
          Date.valueOf(req.getParameter("birth")));

      service.insert(s);
      return "/students?action=list";

    } else {
      return "studentInsert.jsp";
    }
  }
}
