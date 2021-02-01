<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body class="security-app">
	<jsp:include page="defaultheader.jsp"/>
	<div class="container">
		<h3>Register New User</h3>
		<form action="/register" method="post">
			<div class="lc-block">
				<div>
					<input type="text" class="style-4" name="username" placeholder="User Name" />
				</div>
				<div>
					<input type="email" class="style-4" name="useremail" placeholder="Email" />
				</div>
				<div>
					<input type="password" class="style-4" name="userpassword" placeholder="Password" />
				</div>
				<div>
					<input type="text" class="style-4" name="userphone" placeholder="User Phone" />
				</div>
				<div>
					<input type="submit" value="Register" class="button red small" />
				</div>
			</div>
		</form>
	</div>
</body>
</html>