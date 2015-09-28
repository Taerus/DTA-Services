<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
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
		<h1 class="h1 text-center text-uppercase"><spring:message code="page.userdetails.title"></spring:message></h1>
		<br>
		<div class="row">
			<div class="col-sm-6">
				<div class="panel panel-default">
					<div class="panel-heading"><spring:message code="page.userDetails.title" /></div>
					<div class="panel-body ">
						
						<div class="col-xs-6 col-sm-8">
							<h1> ${userDetails.login }</h1>
							<p>  <a href="mailto:${userDetails.email }">${userDetails.email }</a></p>
							<p> <strong> ${userDetails.country.name}, </strong>  ${userDetails.department.name}</p>
						</div>
						<div class="col-xs-6 col-sm-4">						
							<img src="http://s3.amazonaws.com/37assets/svn/765-default-avatar.png" alt="..." class="img-thumbnail">							
						</div>
										
					</div>
					<s:authorize access="hasAnyRole('USER', 'ADMIN')">
						<ul class="list-group">
							<li class="list-group-item">
								<a class="text-info" href="/DTA-Services/message/new?to=${userDetails.id}"><span class="glyphicon glyphicon-envelope" ></span> <spring:message code="page.userDetails.sendMessage" /> </a>
							</li>
							<li class="list-group-item">
								<a class="text-success" href="/DTA-Services/payment/request/${userDetails.id }"><span class="glyphicon glyphicon-usd" ></span> <spring:message code="page.userDetails.requestPayment" /></a>
							</li>
							<li class="list-group-item">
								<a class="text-warning" href="/DTA-Services/payment/${userDetails.id }"><span class="glyphicon glyphicon-usd" ></span> <spring:message code="page.userDetails.sendPayment" /></a>
							</li>
							<s:authorize access="hasRole('ADMIN')">
								<li class="list-group-item">
									<a class="text-danger" data-toggle="modal" data-target="#deleteUser"><span class="glyphicon glyphicon-remove" ></span> <spring:message code="page.userDetails.delete" /></a>
								</li>
							</s:authorize>
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
								<a href="/DTA-Services/advert/show/${ advert.id }"> ${advert.category.name}  - ${advert.title } -  ${advert.price }$</a>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		
		<div id="deleteUser" class="modal fade">
			<div class="modal-dialog">
		    	<div class="modal-content">
		    		<div class="modal-header">
		        		<h1><spring:message code="page.userDetails.user.delete.title"></spring:message>${ userDetails.id }</h1>
		      		</div>
		      		<f:form class="form-horizontal" modelAttribute="user" method="GET" action="/DTA-Services/admin/user/delete/${userDetails.id}/">
						<div class="modal-footer">
				        	<button type="submit" class="btn btn-success"><spring:message code="page.userDetails.user.delete.yes"></spring:message></button>
				        	<button type="button" class="btn btn-danger" data-dismiss="modal"><spring:message code="page.userDetails.user.delete.no"></spring:message></button>
						</div>
					</f:form>
				</div>
			</div>
		</div>
		
	</main>
	<footer>
		<c:import url="_FOOTER_.jsp"></c:import>
	</footer>
</body>
</html>