<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
학생 정보 입력
<form action="/students?action=insert" method="post">
    이름<input type="text" name="name">
    학교<input type="text" name="univ">
    메일<input type="text" name="email">
    생일<input type="date" name="birth">
    <input type="submit">
</form>
</body>
</html>