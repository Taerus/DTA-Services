<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><spring:message code="page.home.title"></spring:message></title>
	<c:import url="_STYLESHEETS_.jsp"></c:import>
	<c:import url="_SCRIPT_.jsp"></c:import>
</head>
<body>
	<header>
		<c:import url="_HEADER_.jsp"></c:import>
	</header>
	<main class="container">
		<div class="row">
			${ myAdvert.id }
		</div>
	</main>
	<footer>
		<c:import url="_FOOTER_.jsp"></c:import>
	</footer>
</body>
</html>