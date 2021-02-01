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
		<h1>Edit Order</h1>
		 <form action="/admin/editorders" method="post">
			  <label>Order User name:</label>${ord.user.username}<br>
			  <label>Order Status:</label><input type="text" name="orderstatus" value ="${ord.orderstatus}"><br>
			  <input type="hidden" value="${ord.orderid}" name="orderid">
			  <div><button type="submit" formaction="/admin/editorders/order">Update Order</button></div>
		</form> 
		
		
	</div>
	
</body>
</html>