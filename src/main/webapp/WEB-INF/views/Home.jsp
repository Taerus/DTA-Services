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
<body ng-app="dta-services" >
	<header>
		<c:import url="_HEADER_.jsp"></c:import>
	</header>
	<main class="container">
		<div class="row">
			<p><spring:message code="page.home.welcome"></spring:message></p>
		</div>
	</main>
	<footer>
		<c:import url="_FOOTER_.jsp"></c:import>
	</footer>
	<c:if test="${showModal !=null }">
		<script>
			$(document).ready(function(){
				$.each($('.wrap-text'),function(){					
					var newHtml = $(this).html();					
					newHtml = newHtml.substr(0,20);
					newHtml+= "...";					
				});
				
				$('#registerModal').modal('show');
				
			});
		</script>
	</c:if>
</body>
</html>