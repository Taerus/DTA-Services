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
<body ng-app="dta_services_users">
	<header>
		<c:import url="_HEADER_.jsp"></c:import>
	</header>
	<main class="container" ng-controller="UsersController as usersController">
		<div class="form-inline">
			<div class="form-group">
				<input class="form-control" type="text" ng-model="usersController.searchCriteria" placeholder="<spring:message code="page.users.search" />"/>
			</div>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>
						<spring:message code="page.users.login"></spring:message>
					</th>
					<th>
						<spring:message code="page.users.email"></spring:message>
					</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="user in usersController.users | filter:usersController.searchCriteria ">
					<td>{{user.login}}</td><td>{{user.email}}</td>
				</tr>
			</tbody>
		</table>
	</main>
	<footer>
		<c:import url="_FOOTER_.jsp"></c:import>
	</footer>
</body>
</html>