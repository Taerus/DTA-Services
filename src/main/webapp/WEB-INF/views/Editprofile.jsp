<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><spring:message code="page.profile.edit.title" /></title>
	<c:import url="_STYLESHEETS_.jsp"></c:import>
	<c:import url="_SCRIPT_.jsp"></c:import>
</head>
<body ng-app="dta-services">
	<header>
		<c:import url="_HEADER_.jsp"></c:import>
	</header>
	<main class="container">
		<div class="page-header">
			<h1><spring:message code="page.profile.edit.title" /></h1>
		</div>
		<div class="well">
			
			<f:form class="form-horizontal" modelAttribute="userProfile" action="/DTA-Services/profile/edit" method="POST" >
				<div class="form-group">        		
	        		<label class="col-sm-3 control-label" >
	        			<spring:message code="page.profile.edit.country" ></spring:message>
	        		</label>
	        		<div class="col-sm-3">
	        			<f:select path="country" class="form-control"  >
	        				<f:options items="${com.dta.services.model.Country.values() }" itemLabel="name" />
	        			</f:select>
	        		</div> 
	        		<label class="col-sm-3 control-label" >
	        			<spring:message code="page.profile.edit.department" ></spring:message>
	        		</label>
	        		<div class="col-sm-3">
	        			<f:select path="department" class="form-control"     >
	        				<f:options items="${com.dta.services.model.Department.values() }" itemLabel="name" />
	        			</f:select>
	        		</div>      		
	        	</div>
				<div class="form-group">
					<label class="col-sm-3 control-label"><spring:message code="page.profile.edit.email" /></label>
					<div class="col-sm-9">
						<f:input type="text" class="form-control" path="email"/>
					</div>
					
				</div>
				<f:hidden path="login" />
				<f:hidden path="password" />
				<div class="form-group">
					<div class="col-sm-9 col-sm-offset-3">
						<button type="submit" class="btn btn-success"><spring:message code="page.profile.edit.save" /> <span class="glyphicon glyphicon-floppy-disk"></span></button>
						<a class="btn btn-danger" href="/DTA-Services/profile"><spring:message code="page.profile.edit.cancel" /> <span class="glyphicon glyphicon-log-out"></span></a>
					</div>
				</div>
			</f:form>
		</div>
	</main>
	<footer>
		<c:import url="_FOOTER_.jsp"></c:import>
	</footer>
	
</body>
</html>