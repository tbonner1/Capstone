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
	<div class="container">
		<h1>Edit Shipping Info</h1>
		 <form action="/admin/editusers" method="post">
			  <label>User name:</label><br>
			  <input type="text"  value ="${usr.username}" name="username">${usr.username}<br>
			  <label>User email:</label><br>
			  <input type="text"  value ="${usr.useremail}" name="useremail">${usr.useremail}<br>
			  <label>User phone:</label><br>
			  <input type="text" value ="${usr.userphone}" name="userphone" >${usr.userphone}<br>
			  <label>User password:</label><br>
			  <input type="text" value ="${usr.userpassword}" name="userpassword">${usr.userpassword}<br>
			  <input type="hidden" value="${usr.userid}" name="userid">
			  <div><button type="submit" formaction="/user/cart/${orderid}">Update</button> </div>
				<c:if test="${param.error ne null}">
					<div class="alert-danger">Invalid registration</div>
				</c:if>
			</form> 
	</div>
	
</body>
</html>