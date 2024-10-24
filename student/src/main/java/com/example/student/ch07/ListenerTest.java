package com.example.student.ch07;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/listener-test")
public class ListenerTest extends HttpServlet {
  ServletContext context = null;

  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    context = getServletContext();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    context.setAttribute("message", "hello world");
    HttpSession session = req.getSession();
    session.setAttribute("msg", "안뇽 세상아~~~~~");
  }
}
