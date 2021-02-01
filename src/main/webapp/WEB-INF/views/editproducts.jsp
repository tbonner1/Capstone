<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body class="security-app">
	<jsp:include page="adminheader.jsp"/>
	<div class="container">
		<h1>Edit Products</h1>
		
		<div class="container">
			<form action="/admin/editproducts" method="post">
				<c:forEach var="pro" items="${products}">
					<div><input type ="radio" value="${pro.productid}" name="productid">${pro.productname}</div>
				</c:forEach>
				<div>
					<button type="submit" formaction="/admin/editproducts/delete">Delete</button> 
				</div>
				<div>
					<button type="submit" formaction="/admin/editproducts/edit">Edit</button> 
				</div>
			</form>
		</div>
	</div>
</body>
</html>
