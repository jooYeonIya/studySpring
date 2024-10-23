package com.example.jjStore;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/products")
public class ProductController extends HttpServlet {
  ProductDAO service;

  @Override
  public void init(ServletConfig config) throws ServletException {
    service = new ProductDAO();
    service.open();
  }

  @Override
  public void destroy() {
    service.close();
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String action = req.getParameter("action");
    String method = req.getMethod();
    String view = "";

    if (action == null) {
      resp.sendRedirect("/products?action=list");
      return;
    }
    try {
      switch (action) {
        case "insert":
          view = insert(req, resp);
          if (method.equals("POST")) {
            resp.sendRedirect(view);
          } else {
            req.getRequestDispatcher(view).forward(req, resp);
          }
          break;
        case "list":
          view = list(req, resp);
          req.getRequestDispatcher(view).forward(req, resp);
          break;
        case "info":
          view = info(req, resp);
          req.getRequestDispatcher(view).forward(req, resp);
        case "update":
        case "delete":
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  public String insert(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
    String method = req.getMethod();

    if (method.equals("POST")) {
      Product product = new Product(
          req.getParameter("name"),
          Integer.parseInt(req.getParameter("price")),
          req.getParameter("maker"),
          Integer.parseInt(req.getParameter("stock"))
      );
      service.insert(product);
      return "/products?action=list";
    } else {
      return "/productsInsert.jsp";
    }
  }

  public String list(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
    List<Product> products = service.findAll();
    req.setAttribute("products", products);
    return "/productsList.jsp";
  }

  public String info(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
    String id = req.getParameter("id");
    Product product = service.findById(id);
    req.setAttribute("product", product);
    return "/productsInfo.jsp";
  }
}
