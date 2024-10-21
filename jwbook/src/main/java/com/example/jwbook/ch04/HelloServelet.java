package com.example.jwbook.ch04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

// 원래는 pom.xml에 적어줘야했는데 이제는 이것만으로도 오케이
@WebServlet("/hello")
@Slf4j
public class HelloServelet extends HttpServlet {
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    log.info("number 1==> {}", req.getParameter("n1"));
    log.info("number 2==> {}", req.getParameter("n2"));
    log.info("op ==> {}", req.getParameter("op"));
    resp.getWriter().append("Served at: ").append(req.getContextPath());
  }
}

