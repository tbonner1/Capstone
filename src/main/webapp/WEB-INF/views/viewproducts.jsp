<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>View Products</title>
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
		<div class="container mb-5">
			<h3>Products</h3>
				<form class="form-inline" action="/viewproducts" method="post">
					<div class="container">
					 	<div class="row justify-content-end"><input type="text" class="form-control"placeholder="Search our Products" name="search"><button class="btn btn-outline-secondary" type="submit" formaction="/viewproducts/search/">Search</button></div>
					</div>
				</form>
			</div>
		<br>
			<div class="container">
				<form action="/viewproducts" method="post">
					<c:forEach var="pro" items="${products}">
						<div class="row">
							<input type="hidden" value="${pro.productid}" name="productid">
						    <div class="col" style="border:1px solid #333">${pro.productname}</div>
						    <div class="col" style="border:1px solid #333"><img src="${pro.productimage}" width="200" height="200"></div>
						    <div class="col" style="border:1px solid #333">${pro.productgenre}</div>
						    <div class="col" style="border:1px solid #333">${pro.productcategory}</div>
						    <div class="col" style="border:1px solid #333">${pro.productcondition}</div>
						    <div class="col" style="border:1px solid #333"><button type="submit" formaction="/viewproducts/productdetails/${pro.productid}">View Product Details</button></div>
					    </div>
					</c:forEach>
				</form>
			</div>
</body>
</html>
