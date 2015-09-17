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
	<script src="/DTA-Services/js/dta_services.js"></script>
</head>
<body ng-app="dta_services">
	<c:import url="_HEADER_.jsp"></c:import>
	<div class="container" ng-controller="AdvertsController as advertsController">
		<div class="form-inline">
			<div class="form-group">
				<input class="form-control" type="text" ng-model="advertsController.search.category.name" placeholder="Recherche par catégorie" />
			</div>
		</div>
		<table class="table table-header-clickable">
			<thead>
				<tr>
					<th ng-click="advertsController.setPredicate('category.name')">Category
					<span ng-if="advertsController.predicate==='category.name'" class="glyphicon glyphicon-chevron-down"></span>
					<span ng-if="advertsController.predicate==='-category.name'" class="glyphicon glyphicon-chevron-up"></span></th>
					<th>Title</th>
					<th>Date of creation</th>
					<th>Description</th>
					<th ng-click="advertsController.setPredicate('price')">Price
					<span ng-if="advertsController.predicate==='price'" class="glyphicon glyphicon-chevron-down"></span>
					<span ng-if="advertsController.predicate==='-price'" class="glyphicon glyphicon-chevron-up"></span></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="advert in advertsController.adverts | filter:advertsController.search:strict | orderBy:advertsController.predicate">
					<td>{{ advert.category.name }}</td>
					<td>{{ advert.title }}</td>
					<td>{{ advert.creation | date }}</td>
					<td>{{ advert.description }}</td>
					<td>{{ advert.price }}</td>
					<td><a href=""><span class="glyphicon glyphicon-search"></span></a></td>
				</tr>
			</tbody>
		</table>
	</div>
	<c:import url="_FOOTER_.jsp"></c:import>
</body>
</html>