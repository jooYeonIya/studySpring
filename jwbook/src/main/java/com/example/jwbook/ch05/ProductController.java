package com.example.jwbook.ch05;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductController extends HttpServlet {

  private ProductService ps = new ProductService();

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String action = req.getParameter("action");
    String view = "";
    String path = "/ch05/";

    if (action.equals("list")) {
      List<Product> products = ps.findAllProduct();
      req.setAttribute("products", products);
      req.getRequestDispatcher(path + "productList.jsp").forward(req, resp);
    } else if (action.equals("info")) {
      req.getRequestDispatcher(path + "productInfo.jsp").forward(req, resp);
    }
  }
}
