<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
    <h2>상품 수정</h2>
    <form action="/products?action=update" method="post">
        <input type="hidden" name="id">
        상품 이름<input type="text" name="name">
        상품 가격<input type="text" name="price">
        상품 제조사<input type="text" name="maker" disabled>
        상품 재고량<input type="text" name="stock" disabled>
        <input type="submit" value="등록">
    </form>
    <button>삭제</button>
</body>
</html>