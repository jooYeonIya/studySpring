package com.example.jwbook.ch05;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@WebServlet("/ch05/cal")
@Slf4j
public class CalServelet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String op = req.getParameter("op");
    int n1 = Integer.parseInt(req.getParameter("n1"));
    int n2 = Integer.parseInt(req.getParameter("n2"));

    Calculator cal = new Calculator();
    cal.setN1(n1);
    cal.setN2(n2);
    cal.setOp(op);

    req.setAttribute("cal", cal);

    String path = "/ch05/";
    req.getRequestDispatcher(path + "calResult.jsp").forward(req, resp);
  }
}
