<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-betal/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_navTop.jsp"></jsp:include>
	
	<section class="container">
<h3>Product List</h3>
<p style="color: red;">${errorstring} </p>
<table class="table table-bordered">
<thead style="background:#f1f1f1">
<tr>
<th> Name</th>
<th> Prices</th>
<th>Edit </th>
<th> Delete</th>
</tr>
</thead>
<tbody>
	<c:forEach items="${productList}" var="product">
	<tr>
		<td>${product.code}</td>
		<td>${product.name}</td>
		<td>${product.price}</td>
		<td><a href="productEdit?code=${product.code}">Edit</a></td>
		<td><a href="producDeletet?code=${product.code}">Delete</a></td>
	</tr>
	</c:forEach>
</tbody>
</table>
<a href="productCreate">Create Product</a>
</section>
<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>