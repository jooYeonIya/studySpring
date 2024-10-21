package com.example.jwbook.ch04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@WebServlet("/cal")
@Slf4j
public class CalServelet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html");
    resp.getWriter().println("한국어 테스트~ loading...");
    
    String n1 = req.getParameter("n1");
    String n2 = req.getParameter("n2");
    String op = req.getParameter("op");
    int result = 0;

    switch (op) {
      case "+":
        result = Integer.parseInt(n1) + Integer.parseInt(n2);
        break;
      case "-":
        result = Integer.parseInt(n1) - Integer.parseInt(n2);
        break;
      case "*":
        result = Integer.parseInt(n1) * Integer.parseInt(n2);
        break;
      case "/":
        result = Integer.parseInt(n1) / Integer.parseInt(n2);
        break;
    }

    resp.getWriter().println(result);
  }
}
