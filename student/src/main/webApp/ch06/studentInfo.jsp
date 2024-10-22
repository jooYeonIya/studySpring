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
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>birth</th>
        <th>univ</th>
        <th>email</th>
    </tr>
    <tr>
        <td>${student.id}</td>
        <td>${student.name}</td>
        <td>${student.birth}</td>
        <td>${student.univ}</td>
        <td>${student.email}</td>
    </tr>
</body>
</html>