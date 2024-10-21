<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
    <%-- isELIgnored 가 true(기본값)이면 -> 이걸 사용해야한다 <%=request.getAttribute("data"); %> --%>
    forward
    ${data}
</body>
</html>