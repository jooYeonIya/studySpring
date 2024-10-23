<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
    <h2>상품 상세 조회</h2>
    <table>
        <tr>
            <th>상품 ID</th>
            <th>상품 이름</th>
            <th>상품 가격</th>
            <th>상품 제조사</th>
            <th>상품 재고량</th>
        </tr>
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.maker}</td>
            <td>${product.stock}</td>
        </tr>
    </table>
    <button onclick="window.location.href='/products?action=update&id=${product.id}'">수정하기</button>
</body>
</html>