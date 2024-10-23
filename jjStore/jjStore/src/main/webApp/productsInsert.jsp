<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
    <h2>상품 등록</h2>
    <form action="/products?action=insert" method="post">
        상품 이름<input type="text" name="name">
        상품 가격<input type="text" name="price">
        상품 제조사<input type="text" name="maker">
        상품 재고량<input type="text" name="stock">
        <input type="submit" value="등록">
    </form>
</body>
</html>