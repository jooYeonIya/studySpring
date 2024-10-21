package com.example.jwbook.ch04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/forward")
public class ForwardServelet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setAttribute("data", "공유되는 값");
    req.getRequestDispatcher("/forward.jsp").forward(req, resp);

//    forward는 현재 서블릿에서 다른 서블릿이나 JSP로 요청과 응답을 넘겨 처리하게 합니다.
//    브라우저의 주소창은 변경되지 않고, 내부적으로 요청이 전달됩니다.
//    브라우저 주소는 그대로: /forward 그대로 남아있음.
//    요청을 forward.jsp로 넘기면서 data 속성도 함께 전달.
//    브라우저는 다른 페이지로 이동하는 것을 알지 못함.
  }
}
