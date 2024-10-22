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
학생 정보 조회
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>birth</th>
        <th>univ</th>
        <th>email</th>
    </tr>
    <c:forEach var="s" varStatus="i" items="${students}">
    <tr>
        <td>${s.id}</td>
        <td>${s.name}</td>
        <td>${s.birth}</td>
        <td>${s.univ}</td>
        <td>${s.email}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>