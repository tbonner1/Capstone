<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<jsp:include page="adminheader.jsp"/>
	<div class="container">
		<h1>Edit Products</h1>
		 <form action="/admin/editproducts" method="post">
			  <label>Product name:</label><br>
			  <input type="text" name="productname" value ="${pro.productname}" name="productname"><br>
			  <label>Product Price:</label><br>
			  <input type="text" name="productprice" value ="${pro.productprice}" name="productprice"><br>
			  <label>Product Description:</label><br>
			  <textarea name="productdescription" name="productdescription">${pro.productdescription}</textarea><br><br>
			  <label>Product image source:</label><br>
			  <input type="text" name="productimage" value="${pro.productimage}" name="productimage"><br>
			  
			  <label>Product Genre:</label><br>
			  <input type="text" list="productgenres" value="${pro.productgenre}" name="productgenre"/>
			  <datalist id="productgenres">
			  	<c:forEach var="productgenre" items="${productgenres}">
			  		<option>${productgenre}</option>
			  	</c:forEach>
			  </datalist><br>
			  
			  <label>Product Category:</label><br>
			  <input type="text" list="productcategories" value="${pro.productcategory}" name="productcategory"/>
			  <datalist id="productcategories">
			  	<c:forEach var="productcategory" items="${productcategories}">
			  		<option>${productcategory}</option>
			  	</c:forEach>
			  </datalist><br>
			  
			  <label>Product Condition:</label><br>
			  <input type="text" list="productcoditions" value="${pro.productcondition}" name="productcondition"/>
			  <datalist id="productcoditions">
			  	<c:forEach var="productcondition" items="${productcoditions}">
			  		<option>${productcondition}</option>
			  	</c:forEach>
			  </datalist><br>
			  
			  <input type="hidden" value="${pro.productid}" name="productid">
			  <div><button type="submit" formaction="/admin/editproducts/product">Update </button> </div>
			</form> 
		
	</div>
	
</body>
</html>