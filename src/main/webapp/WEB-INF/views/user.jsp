<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Spring Security Example - ProgrammingFree</title>
</head>
<body class="security-app">
	<jsp:include page="adminheader.jsp"/>
	<div class="container">
		<h1>Edit Users</h1>
		 <form action="/admin/editusers" method="post">
			  <label>User name:</label><br>
			  <input type="text" name="username" value ="${usr.username}" name="username"><br>
			  <label>User email:</label><br>
			  <input type="text" name="useremail" value ="${usr.useremail}" name="useremail"><br>
			  <label>User phone:</label><br>
			  <input type="text" name="userphone" value ="${usr.userphone}" name="userphone"><br>
			  <label>User password:</label><br>
			  <input type="text" name="userpassword" value ="${usr.userpassword}" name="userpassword"><br>
			  <input type="hidden" value="${usr.userid}" name="userid">
			  <div><button type="submit" formaction="/admin/editusers/user">Update </button> </div>
			</form> 
		
	</div>
	
</body>
</html>