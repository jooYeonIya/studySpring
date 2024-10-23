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
<h2> 뉴스 목록</h2>
<c:forEach var="news" varStatus="i" items="${newsList}">
<ul>
    <li>${i.count}</li>
    <li><a href="/news?action=view&aid=${news.aid}">${news.title}</a></li>
    <li>${news.date}</li>
</ul>
</c:forEach>
</body>
</html>