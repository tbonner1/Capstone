<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body class="security-app">
<c:choose>
	  <c:when test="${pageContext.request.userPrincipal.name == 'admin'}">
	    <jsp:include page="adminheader.jsp"/>
	  </c:when>
	  <c:when test="${pageContext.request.userPrincipal.name != null}">
	    <jsp:include page="userheader.jsp"/>
	  </c:when>
	  <c:otherwise>
	    <jsp:include page="defaultheader.jsp"/>
	  </c:otherwise>
	</c:choose>
	<div class="lc-block">
		<h1>Edit User Info</h1>
		 <form action="/user/{username}" method="get">
			  <label>User name:</label><br>
			  <input type="text" name="username" value ="${usr.username}"><br>
			  <label>User email:</label><br>
			  <input type="text" name="useremail" value ="${usr.useremail}"><br>
			  <label>User phone:</label><br>
			  <input type="text" name="userphone" value ="${usr.userphone}"><br>
			  <label>User password:</label><br>
			  <input type="text" name="userpassword" value ="${usr.userpassword}"><br>
			  <input type="hidden" value="${usr.userid}" name="userid">
			  <div><button type="submit" formaction="/user/save">Update </button> </div>
			</form> 
		
	</div>
	
</body>
</html>