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
		<h3>About</h3>
		<br>
		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Facilisis volutpat est velit egestas dui id ornare arcu. Mi ipsum faucibus vitae aliquet nec ullamcorper. Tempus quam pellentesque nec nam aliquam sem et. Massa id neque aliquam vestibulum morbi blandit. Pharetra massa massa ultricies mi. Tempor id eu nisl nunc mi ipsum faucibus vitae. Volutpat blandit aliquam etiam erat velit scelerisque in dictum. Tortor id aliquet lectus proin nibh nisl condimentum id venenatis. Ullamcorper morbi tincidunt ornare massa eget egestas purus. Libero justo laoreet sit amet. Consequat interdum varius sit amet mattis vulputate enim nulla aliquet. Consectetur adipiscing elit pellentesque habitant morbi tristique senectus et netus. Id diam vel quam elementum pulvinar etiam non. Neque viverra justo nec ultrices dui. Purus semper eget duis at tellus at urna condimentum mattis. Libero nunc consequat interdum varius sit amet mattis. Diam maecenas sed enim ut sem viverra aliquet.</p>
	
		<p>Metus aliquam eleifend mi in nulla posuere sollicitudin. Donec ac odio tempor orci dapibus. Vulputate odio ut enim blandit volutpat maecenas. Vestibulum lorem sed risus ultricies tristique nulla aliquet. Imperdiet nulla malesuada pellentesque elit eget gravida cum sociis natoque. Ac odio tempor orci dapibus ultrices in iaculis. Risus nullam eget felis eget nunc lobortis mattis. Elementum tempus egestas sed sed risus. Sed risus ultricies tristique nulla aliquet enim tortor at auctor. Lacinia quis vel eros donec ac odio tempor orci. Morbi tristique senectus et netus et malesuada. Ultrices in iaculis nunc sed augue. Vel fringilla est ullamcorper eget nulla facilisi etiam.</p>
	
		<p>Facilisi cras fermentum odio eu. Nunc scelerisque viverra mauris in aliquam sem. Suspendisse in est ante in nibh mauris cursus. Et magnis dis parturient montes nascetur ridiculus mus mauris vitae. Placerat duis ultricies lacus sed turpis tincidunt id aliquet risus. Nunc sed blandit libero volutpat sed. Fermentum odio eu feugiat pretium nibh ipsum consequat nisl vel. Id aliquet risus feugiat in ante metus. Duis tristique sollicitudin nibh sit amet commodo nulla facilisi nullam. Dolor sit amet consectetur adipiscing elit ut aliquam purus. Egestas dui id ornare arcu odio ut sem. Imperdiet massa tincidunt nunc pulvinar sapien et ligula ullamcorper. Velit sed ullamcorper morbi tincidunt ornare massa. Mi bibendum neque egestas congue quisque egestas. Ut sem viverra aliquet eget sit amet tellus cras.</p>
	</div>
</body>
</html>
