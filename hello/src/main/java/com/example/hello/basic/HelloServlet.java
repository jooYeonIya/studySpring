package com.example.hello.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;

import java.io.IOException;

@WebServlet("/hello-servlet")
// log를 남겨주는 클래스를 사용할 수 있음
@Slf4j
public class HelloServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    System.out.println("req" + req.getMethod());      //GET
//    System.out.println(req.getProtocol());    //HTTP/1.1

    log.debug("get method {}", req.getMethod());
    log.warn("warning {}", req.getMethod());
    log.error("error {}", req.getMethod());
    log.trace("trace {}", req.getMethod());
    log.info("info {}", req.getMethod());

    //아래처럼 쓰는 건 안돼
    //log.trace("trace " + req.getMethod());
  }
}
