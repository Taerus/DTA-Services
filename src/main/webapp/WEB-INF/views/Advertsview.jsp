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
<body ng-app="dta_services">
	<c:import url="_HEADER_.jsp"></c:import>
	<div class="container" ng-controller="AdvertController as advert">
		<div class="form-inline">
			<div class="form-group">
				<input class="form-control" type="text" ng-model="search.category.name" />
			</div>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>Category</th>
					<th>Title</th>
					<th>Date of creation</th>
					<th>Description</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="item in advert.list | filter:search:strict">
					<td>{{ item.category.name }}</td>
					<td>{{ item.title }}</td>
					<td>{{ item.creation | date }}</td>
					<td>{{ item.description }}</td>
					<td>{{ item.price }}</td>
				</tr>
			</tbody>
		</table>
	</div>
	<c:import url="_FOOTER_.jsp"></c:import>
</body>
</html>