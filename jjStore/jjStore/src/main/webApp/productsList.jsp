<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
    <h2>상품 목록</h2>
    <a href="/products?action=insert">상품 등록하기</a>
    <table>
        <tr>
            <th>상품 이름</th>
            <th>상품 가격</th>
        </tr>
        <c:forEach var="product" varStatus="i" items="${products}">
        <tr>
            <td><a href="/products?action=info&id=${product.id}">${product.name}</a></td>
            <td>${product.price}</td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>