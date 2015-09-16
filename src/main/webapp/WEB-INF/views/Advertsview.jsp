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
	<div class="container">
		<div class="row" ng-controller="AdvertController as advert">
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
					<tr>
						<td ng-repeat="ad in advert.list">{{ ad.category_id.name }}</td>
						<td ng-repeat="ad in advert.list">{{ ad.title }}</td>
						<td ng-repeat="ad in advert.list">{{ ad.creation | timedate }}</td>
						<td ng-repeat="ad in advert.list">{{ ad.description }}</td>
						<td ng-repeat="ad in advert.list">{{ ad.price }}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<c:import url="_FOOTER_.jsp"></c:import>
</body>
</html>