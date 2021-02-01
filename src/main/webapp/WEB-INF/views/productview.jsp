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
	
	<div class="container">
		<div class="container mb-5">
	            <div class="card">
	                <img class="card-img-top" src="${product.productimage}" width="500" height="500">
	                <div class="card-body">
	                    <h4 class="card-title">${product.productname}</h4>
	                    <p class="card-text">${product.productdescription}</p>
	                    <form action="/user/order/addproduct/${product.productid}" method="post">
	                    	<button class="btn btn-warning btn-block" type="submit">Add to Order</button>
	                    </form>
	                </div>
	            </div>
	    </div>
	    <div class="container">
			<form action="/viewproducts" method="get">
				<div>
					<button class="btn btn-success btn-block" type="submit">Return To Product List</button><br>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
