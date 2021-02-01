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
		<h3>Edit Users</h3>
		
		<form action="/admin/editusers" method="post">
			<c:forEach var="user" items="${users}">
				<div><input type ="radio" value="${user.userid}" name="userid">${user.username}</div>
			</c:forEach>
			<div>
				<button type="submit" formaction="/admin/editusers/delete">Delete</button> 
			</div>
			<div>
				<button type="submit" formaction="/admin/editusers/edit">Edit</button> 
			</div>
		</form>
	</div>
	
</body>
</html>
