<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
    <%!
        String[] members = {"A", "B", "C", "D"};
        int num = 10;

        int cal(int number) {
            return number + num;
        }
    %>

    <h2>jsp test</h2>
    <%= cal(10) %>

    <br>

    계산기 정답은???? ${result}

</body>
</html>