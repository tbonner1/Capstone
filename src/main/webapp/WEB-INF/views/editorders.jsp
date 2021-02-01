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
		<h1>Edit Orders</h1>
		
	<form action="/admin/editusers" method="post">
		<c:forEach var="order" items="${orders}">
			<div><input type ="radio" value="${order.orderid}" name="orderid">Customer: ${order.user.username} <br> Status: ${order.orderstatus}</div>
			
			<div>
				<button type="submit" formaction="/admin/editorders/delete">Delete</button> 
			</div>
			<div>
				<button type="submit" formaction="/admin/editorders/edit">Edit</button> 
			</div>
		</c:forEach>
	</form>
	</div>
	
</body>
</html>
