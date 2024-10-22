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
    <table>
        <tr>
            <th>seq</th>
            <th>제품명</th>
            <th>제품 가격</th>
        </tr>
        <c:forEach var="p" varStatus="i" items="${products}">
            <td>${i.count}</td>
            <td><a href="/products?action=info&id=${p.id}">${p.name}</a></td>
            <td>${p.price}</td>
        </c:forEach>
        <tr>
            <td>1</td>
            <td>갤럭시</td>
            <td>10,000</td>
        </tr>
        <tr>
            <td>2</td>
            <td>아이폰</td>
            <td>20,000</td>
        </tr>
    </table>
</body>
</html>