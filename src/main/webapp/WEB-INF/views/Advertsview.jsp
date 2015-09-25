<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
				<input class="form-control" type="text" ng-model="advertsController.search.author.login" placeholder="Recherche par author" />
			</div>
		</div>
		<form class="form-horizontal" method="POST" action="/DTA-Services/advert/deleteSelected">
			<table class="table table-header-clickable row">
				<thead>
					<tr>
						<th ng-click="advertsController.setPredicate('category.name')" class="col-md-2">Category
						<span ng-if="advertsController.predicate==='category.name'" class="glyphicon glyphicon-chevron-down"></span>
						<span ng-if="advertsController.predicate==='-category.name'" class="glyphicon glyphicon-chevron-up"></span></th>
						<th class="col-md-2">Title</th>
						<th ng-click="advertsController.setPredicate('creation')" class="col-md-2">Date of creation
						<span ng-if="advertsController.predicate==='creation'" class="glyphicon glyphicon-chevron-down"></span>
						<span ng-if="advertsController.predicate==='-creation'" class="glyphicon glyphicon-chevron-up"></span></th>
						<th class="col-md-2">Description</th>
						<th ng-click="advertsController.setPredicate('price')" class="col-md-2">Price
						<span ng-if="advertsController.predicate==='price'" class="glyphicon glyphicon-chevron-down"></span>
						<span ng-if="advertsController.predicate==='-price'" class="glyphicon glyphicon-chevron-up"></span></th>
						<th class="col-md-1"></th>
						<th class="col-md-1"></th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="advert in advertsController.adverts | filter:advertsController.search:strict | orderBy:advertsController.predicate">
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
				<button type="submit" class="btn btn-danger">Supprimer sélection</button>
			</c:if>
		</form>
	</div>
	<c:import url="_FOOTER_.jsp"></c:import>
</body>
</html>