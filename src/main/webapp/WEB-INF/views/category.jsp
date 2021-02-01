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
		<h3>View Categories</h3>
		<form action="/admin/editproducts/categories" method="post">
			<c:forEach var="cat" items="${categories}">
				<div>${cat}<button type="submit" value="${cat}" name="chosenCategory">View Products</button></div>
			</c:forEach>
		</form>
	</div>
	
</body>
</html>
