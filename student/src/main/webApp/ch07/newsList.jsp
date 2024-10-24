<%@ page language="java" contentType="text/html;"  isELIgnored="false" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="asdf">
  <title>Title</title>
</head>
<body>
<h2>뉴스 목록</h2>
    <c:forEach var="news" varStatus="i" items="${newsList}">
    <ul>
        <li>${i.count}</li>
        <li><a href="/news?action=info&aid=${news.aid}">${news.title}</a></li>
        <li>${news.date}</li>
    </ul>
    </c:forEach>

<h2>뉴스 등록</h2>
    <form action="/news?action=create" method="post">
        title<input type="text" name="title">
        img<input type="text" name="img">
        content<textarea name="content" cols="30", rows="10"></textarea>
        <input type="submit" value="등록">
    </form>
</body>
</html>