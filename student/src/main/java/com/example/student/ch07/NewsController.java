package com.example.student.ch07;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/news")
public class NewsController extends HttpServlet {
  NewsDAO service;
  ServletContext context;

  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    service = new NewsDAO();
    context = getServletContext();
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String method = req.getMethod();
    String action = req.getParameter("action");
    String view = "";
    String path = "/ch07/";

    if (action == null) {
      resp.sendRedirect("/news?action=list");
      return;
    }

    try {
      switch (action) {
        case "list":
          view = list(req, resp);
          context.getRequestDispatcher(path + view).forward(req, resp);
          break;

        case "info":
          view = info(req, resp);
          context.getRequestDispatcher(path + view).forward(req, resp);
          break;

        case "create":
          view = create(req, resp);
          if (view.startsWith("redirect")) {
            resp.sendRedirect(view.substring(10));
          }
          break;
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public String list(HttpServletRequest req, HttpServletResponse resp) {
    req.setAttribute("newsList", service.findAll());
    return "newsList.jsp";
  }

  public String info(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
    String aid = req.getParameter("aid");
    News news = service.findByAid(aid);
    req.setAttribute("news", news);
    return "newsInfo.jsp";
  }

  public String create(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
    News news = new News(
        req.getParameter("title"),
        req.getParameter("img"),
        req.getParameter("content")
    );
    service.addNews(news);
    return "redirect:/news?action=list";
  }
}
