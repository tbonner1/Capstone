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
		<h3>View Genres</h3>
		<div class="container">
		<form action="/admin/editproducts/genre" method="post">
			<c:forEach var="gen" items="${genres}">
				<div>${gen}<button type="submit" value="${gen}" name="chosenGenre">View Products</button></div>
			</c:forEach>
		</form>
		</div>
	</div>
</body>
</html>
