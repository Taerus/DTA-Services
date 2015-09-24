<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><spring:message code="page.userDetails.title"></spring:message></title>
	<c:import url="_STYLESHEETS_.jsp"></c:import>
	<c:import url="_SCRIPT_.jsp"></c:import>
</head>
<body>
	<header>
		<c:import url="_HEADER_.jsp"></c:import>
	</header>
	<main class="container">
		<div class="row">
			<div class="col-sm-6">
				<div class="panel panel-default">
					<div class="panel-heading"><spring:message code="page.userDetails.title" /></div>
					<div class="panel-body ">
						
						<div class="col-xs-6 col-sm-8">
							<h1> ${userDetails.login }</h1>
							<p>  <a href="mailto:${userDetails.email }">${userDetails.email }</a></p>
<<<<<<< HEAD
							<p> <strong> ${userDetails.country}, </strong>  ${userDetails.department}</p>
							<div class="form-inline">
								<div class="form-group">
									<a href="/DTA-Services/payment/${ userDetails.id }" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-envelope" ></span></a>
									<a class="btn btn-success btn-sm"><span class="glyphicon glyphicon-usd" ></span></a>
								</div>
							</div>							
=======
							<p> <strong> ${userDetails.country}, </strong>  ${userDetails.department}</p>								
>>>>>>> master
						</div>
						<div class="col-xs-6 col-sm-4">						
							<img src="http://s3.amazonaws.com/37assets/svn/765-default-avatar.png" alt="..." class="img-thumbnail">							
						</div>
										
					</div>
					<s:authorize access="hasRole('USER')">
						<ul class="list-group">
							<li class="list-group-item">
								<a class="text-info" href="#"><span class="glyphicon glyphicon-envelope" ></span> <spring:message code="page.userDetails.sendMessage" /> </a>
							</li>
							<li class="list-group-item">
								<a class="text-success" href="#"><span class="glyphicon glyphicon-usd" ></span> <spring:message code="page.userDetails.requestPayment" /></a>
							</li>
							<li class="list-group-item">
								<a class="text-warning" href="#"><span class="glyphicon glyphicon-usd" ></span> <spring:message code="page.userDetails.sendPayment" /></a>
							</li>
						</ul>						
					</s:authorize>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="panel panel-default">
					<div class="panel-heading"><spring:message code="page.userDetails.adverts.title" /></div>
										
					
					<ul class="list-group">
						<c:forEach items="${userDetails.adverts }" var="advert">						
							<li class="list-group-item">
								<a href="/DTA-Services/advert/${ advert.id }"> ${advert.category.name}  - ${advert.title } -  ${advert.price }$</a>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</main>
	<footer>
		<c:import url="_FOOTER_.jsp"></c:import>
	</footer>
</body>
</html>