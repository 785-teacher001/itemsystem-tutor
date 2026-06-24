<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品管理</title>
</head>
<body>
	<h1>商品登録</h1>
	<form action="/itemsystem-tutor/ItemServlet" method="post">
	<table border="1">
		<tr>
			<th>カテゴリコード</th>
			<td>
				<input type="number" name="categryCode" />
			</td>
		</tr>
		<tr>
			<th>商品名</th>
			<td>
				<input type="text" name="name" />
			</td>
		</tr>
		<tr>
			<th>価格</th>
			<td>
				<input type="number" name="price" />
			</td>
		</tr>
	</table>
	<input type="hidden" name="action" value="store" />
	<button>登録</button>
	</form>
</body>
</html>