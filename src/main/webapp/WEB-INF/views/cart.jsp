<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<h1>Cart </h1>
	<form action="/viewproducts" method="post">
		<c:forEach var="pro" items="${products}">
			<div><input type="hidden" value="${pro.productid}" name="productid"> ${pro.productname} </div>
		</c:forEach>
		<button type="submit" formaction="/user/cart/shippinginfo/${order.orderid}">Ship It</button>
	</form>
	</div>
	
</body>
</html>
