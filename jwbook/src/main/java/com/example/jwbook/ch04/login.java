package com.example.jwbook.ch04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class login extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String id = req.getParameter("id");
    HttpSession session = req.getSession();
    // redirect 일 때는 세션에 담아서 보내는 편
    session.setAttribute("id", id);
    resp.sendRedirect("loginOK.jsp");
  }
}
