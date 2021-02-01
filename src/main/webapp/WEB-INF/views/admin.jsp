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
	
	<div class="container mt-5">
	    <div class="container">
			<form action="/admin/editproducts" method="get">
				<div><button class="btn btn-warning btn-block" type="submit">Edit Products</button><br></div>
			</form>
			
			<form action="/admin/genres" method="get">
				<div><button class="btn btn-warning btn-block" type="submit">Edit Products by Genre</button><br></div>
			</form>
			
			<form action="/admin/categories" method="get">
				<div><button class="btn btn-warning btn-block" type="submit">Edit Products by Category</button><br></div>
			</form>
			
			<form action="/admin/editusers" method="get">
				<div><button class="btn btn-warning btn-block" type="submit">Edit Users</button><br></div>
			</form>
			
			<form action="/admin/editorders" method="get">
				<div><button class="btn btn-warning btn-block" type="submit">Edit Orders</button><br></div>
			</form>
			
			<form action="/admin/pop" method="get">
				<div><button class="btn btn-warning btn-block" type="submit">Populate the Products Database</button><br></div>
			</form>
		</div>
	</div>
</body>
</html>
