<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
학생 1인 조회
    <form action="/students?action=update" method="post">
        <input type="hidden" name="id" value="${student.id}">
        이름<input type="text" name="name" value="${student.name}" disabled>
        학교<input type="text" name="univ" value="${student.univ}">
        메일<input type="text" name="email" value="${student.email}">
        생일<input type="date" name="birth" value="${student.birth}" disabled>
        <input type="submit" value="수정">
    </form>
<a href="/students?action=delete&id=${student.id}">삭제</a>
</body>
</html>