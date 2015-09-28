<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><spring:message code="page.advertsview.title"></spring:message></title>
	<c:import url="_STYLESHEETS_.jsp"></c:import>
	<c:import url="_SCRIPT_.jsp"></c:import>
	<script src="/DTA-Services/js/controller/adverts-controller.js"></script>
	<script src="/DTA-Services/js/service/adverts-service.js"></script>
</head>
<body ng-app="dta-services">
	<header>
		<c:import url="_HEADER_.jsp"></c:import>
	</header>
	
	<main class="container">
		<div ng-controller="AdvertsController as advertsController">
			<h1 class="h1 text-center text-uppercase"><spring:message code="page.advertsview.title"></spring:message></h1>
			<br>
			<div class="form-inline">
				<div class="form-group">
					<input class="form-control" type="text" ng-model="advertsController.search.category.name" placeholder="<spring:message code="page.advertsview.advert.search.category"></spring:message>" />
					<input class="form-control" type="text" ng-model="advertsController.search.author.login" placeholder="<spring:message code="page.advertsview.advert.search.author"></spring:message>" />
				</div>
			</div>
			<form class="form-horizontal" method="POST" action="/DTA-Services/advert/deleteSelected">
				<table class="table table-header-clickable table-hover row">
					<thead>
						<tr>
							<th ng-click="advertsController.setPredicate('category.name')" class="col-md-2"><spring:message code="page.advertsview.advert.category"></spring:message>
							<span ng-if="advertsController.predicate==='category.name'" class="glyphicon glyphicon-chevron-down"></span>
							<span ng-if="advertsController.predicate==='-category.name'" class="glyphicon glyphicon-chevron-up"></span></th>
							<th class="col-md-2"><spring:message code="page.advertsview.advert.title"></spring:message></th>
							<th class="col-md-2"><spring:message code="page.advertsview.advert.date"></spring:message></th>
							<th class="col-md-2"><spring:message code="page.advertsview.advert.description"></spring:message></th>
							<th ng-click="advertsController.setPredicate('price')" class="col-md-2"><spring:message code="page.advertsview.advert.credit"></spring:message>
							<span ng-if="advertsController.predicate==='price'" class="glyphicon glyphicon-chevron-down"></span>
							<span ng-if="advertsController.predicate==='-price'" class="glyphicon glyphicon-chevron-up"></span></th>
							<th class="col-md-1"></th>
							<c:if test="${isAdmin }">
								<th class="col-md-1"></th>
							</c:if>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="advert in advertsController.adverts | filter:advertsController.search:strict | orderBy:'-creation' | orderBy:advertsController.predicate">
							<td>{{ advert.category.name }}</td>
							<td>{{ advert.title }}</td>
							<td>{{ advert.creation | date:'le dd-MM-yyyy à HH:mm:ss' }}</td>
							<td>{{ advert.description }}</td>
							<td>{{ advert.price }}</td>
							<td><a href="/DTA-Services/advert/show/{{ advert.id }}/"><span class="glyphicon glyphicon-search"></span></a></td>
							<c:if test="${isAdmin }">
								<td><input type="checkbox" name="{{advert.id}}"></td>
							</c:if>
						</tr>
					</tbody>
				</table>
				<c:if test="${isAdmin }">
					<button type="submit" class="btn btn-danger"><spring:message code="page.advertsview.advert.delete"></spring:message></button>
				</c:if>
			</form>
		</div>
	</main>
	
	<footer>
		<c:import url="_FOOTER_.jsp"></c:import>
	</footer>
	
</body>
</html>