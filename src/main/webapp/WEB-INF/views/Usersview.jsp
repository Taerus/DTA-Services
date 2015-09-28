<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><spring:message code="page.users.title"></spring:message></title>
	<c:import url="_STYLESHEETS_.jsp"></c:import>
	<c:import url="_SCRIPT_.jsp"></c:import>
	<script src="/DTA-Services/js/dta_services_users.js"></script>
</head>
<body >
	<header>
		<c:import url="_HEADER_.jsp"></c:import>
	</header>
	<main ng-app="dta_services_users" class="container" ng-controller="UsersController as usersController">
		<h1 class="h1 text-center text-uppercase"><spring:message code="page.usersview.title"></spring:message></h1>
		<br>
		<div class="form-inline">
			<div class="form-group">
				<input class="form-control" type="text" ng-model="usersController.search.login" placeholder="<spring:message code="page.users.search" />"/>
			</div>
		</div>
		<table class="table table-hover table-header-clickable table-row-clickable">
			<thead>
				<tr >
					<th ng-click="usersController.setPredicate('login')">																			
						<spring:message code="page.users.login" />						 
						<span ng-if="usersController.predicate==='login'" class="glyphicon glyphicon-chevron-down"></span>
						<span ng-if="usersController.predicate==='-login'" class="glyphicon glyphicon-chevron-up"></span>						
					</th>
					<th ng-click="usersController.setPredicate('email')">
						<spring:message code="page.users.email" />
						<span ng-if="usersController.predicate==='email'" class="glyphicon glyphicon-chevron-down"></span>
						<span ng-if="usersController.predicate==='-email'" class="glyphicon glyphicon-chevron-up"></span>
					</th>
					<th ng-click="usersController.setPredicate('country')">
						<spring:message code="page.users.country" />
						<span ng-if="usersController.predicate==='country'" class="glyphicon glyphicon-chevron-down"></span>
						<span ng-if="usersController.predicate==='-country'" class="glyphicon glyphicon-chevron-up"></span>
					</th>
					<th>
					</th>
					<c:if test="${isAdmin }">
						<th class="col-md-1"></th>
					</c:if>
				</tr>
			</thead>
			<tbody>
				<tr class="clickable" ng-repeat="user in usersController.users | filter:usersController.search | orderBy:usersController.predicate" 
					ng-click="usersController.redirectTo(user.id)">
					<td>{{user.login}}</td>
					<td>{{user.email}}</td>
					<td>{{user.country}}</td>
					<td>
						<c:if test="${isAdmin }">
							<a href="/DTA-Services/admin/user/{{user.id}}"><span class="glyphicon glyphicon-eye-open"></span></a>
						</c:if>
						<c:if test="${ !isAdmin }">
							<a href="/DTA-Services/user/{{user.id}}"><span class="glyphicon glyphicon-eye-open"></span></a>
						</c:if>		
					</td>
					<c:if test="${isAdmin }">
						<td><input type="checkbox" name="{{user.id}}"></td>
					</c:if>
				</tr>
			</tbody>
		</table>
		<c:if test="${isAdmin }">
			<button type="submit" class="btn btn-danger"><spring:message code="page.advertsview.advert.delete"></spring:message></button>
		</c:if>
	</main>
	<footer>
		<c:import url="_FOOTER_.jsp"></c:import>		
	</footer>
</body>
</html>