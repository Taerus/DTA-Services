<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><spring:message code="page.profile.title"></spring:message></title>
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
					<div class="panel-heading"><spring:message code="page.profile.title" /></div>
					<div class="panel-body ">
						
						<div class="col-xs-6 col-sm-8">
							<h1> ${userProfile.login }</h1>
							<p>  ${userProfile.email }</p>
							<p> <strong> ${userProfile.country}, </strong>  ${userProfile.department}</p>
							<p> 
								<strong> <spring:message code="page.profile.balance" /> : </strong>	
								<c:if test="${userProfile.balance >=0  }">
									<span class="text-success"> ${userProfile.balance }</span>
								</c:if>
								<c:if test="${userProfile.balance < 0  }">
									<span class="text-danger"> ${userProfile.balance }</span>
								</c:if>
								<span class="glyphicon glyphicon-bitcoin"></span>
								
							</p>							
						</div>
						<div class="col-xs-6 col-sm-4">						
							<img src="http://s3.amazonaws.com/37assets/svn/765-default-avatar.png" alt="..." class="img-thumbnail">							
						</div>
						<c:if test="${edited}">				
							<div class="col-sm-12 alert alert-success alert-dismissable">
								<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								<spring:message code="page.profile.updated" />
							</div>
						</c:if>
										
					</div>
					<ul class="list-group">
						<li class="list-group-item">
							<a href="/DTA-Services/profile/edit"><span class="glyphicon glyphicon-pencil"></span> <spring:message code="page.profile.edit" /></a>
						</li>						
					</ul>
					
					
				</div>
				
			</div>
			<div class="col-sm-6">
				<div class="panel panel-default">
					<div class="panel-heading"><spring:message code="page.profile.adverts.title" /></div>
					<ul class="list-group">
						<c:forEach items="${userProfile.adverts}" var="advert">
							<li class="list-group-item"><a href="/DTA-Services/advert/${advert.id }">${advert.category.name}  - ${ advert.title} - ${advert.price }$</a></li>					
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