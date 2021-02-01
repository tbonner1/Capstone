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
		<div id="slider1" class="carousel slide mb-5" data-ride="carousel">
            <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="d-block img-fluid" src="http://www.dzjavalas.lt/wp-content/uploads/2016/10/musical-instruments.jpg" alt="First Slide" style="width:100%; height: 700px;">
                <div class="carousel-caption d-none d-md-block">
                    <h3>Instruments</h3>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Possimus, illo?</p>
                </div>
            </div>
            <div class="carousel-item">
                <img class="d-block img-fluid" src="https://mymodernmet.com/wp/wp-content/uploads/2019/11/vinyl-records-2.jpg" alt="Second Slide" style="width:100%; height: 700px;">
                <div class="carousel-caption d-none d-md-block">
                    <h3>Vinyl</h3>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Possimus, illo?</p>
                </div>
            </div>
            <div class="carousel-item">
                <img class="d-block img-fluid" src="https://christiancopyrightsolutions.com/wp-content/uploads/2015/06/christianmusicdead.png" alt="Third Slide" style="width:100%; height: 700px;">
                <div class="carousel-caption d-none d-md-block">
                    <h3>Music</h3>
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Possimus, illo?</p>
                </div>
            </div>
            </div>
        </div>
	</div>
	
	<script>
        $('.carousel').carousel({
            interval: 5000,
            keyboard: true,
            pause: 'hover',
            wrap: true
        });
    </script>
</body>
</html>
