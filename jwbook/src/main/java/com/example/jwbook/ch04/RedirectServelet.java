package com.example.jwbook.ch04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/redirect")
public class RedirectServelet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setAttribute("data", "공유되는 값");
    resp.sendRedirect("/redirect.jsp");

//    redirect는 현재 서블릿에서 클라이언트(브라우저)에게 새로운 URL로 요청을 다시 보내도록 응답합니다.
//    이 과정에서 브라우저의 주소창이 변경됩니다.
//    브라우저 주소가 바뀜: /redirect에서 redirect.jsp로 변경됨.
//    새로운 요청을 다시 보내므로, 이전 요청에 있던 데이터는 전달되지 않음.
//    서버는 클라이언트에게 redirect.jsp로 가라고 명령을 보내고(302), 클라이언트가 다시 요청을 보냄(200)
  }
}
