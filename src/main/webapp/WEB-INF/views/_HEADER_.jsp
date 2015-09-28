<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="s"%>

<nav class="navbar navbar-default" >
	<div class="container-fluid">
		<a class="navbar-brand" href="/DTA-Services"><spring:message code="page.header.title" /></a>
		<s:authorize access="hasRole('USER') or isAnonymous()">
			<ul class="nav navbar-nav">
				<li><a href="/DTA-Services/users/"><spring:message code="page.header.users" /></a></li>
				<li><a href="/DTA-Services/adverts/"><spring:message code="page.header.adverts" /></a></li>
			</ul>
		</s:authorize>
		<s:authorize access="hasRole('ADMIN')">
			<ul class="nav navbar-nav">
				<li><a href="/DTA-Services/admin/users/"><spring:message code="page.header.users" /></a></li>
				<li><a href="/DTA-Services/admin/adverts/"><spring:message code="page.header.adverts" /></a></li>
			</ul>
		</s:authorize>
		

		<s:authorize access="hasAnyRole('USER','ADMIN')">					
			
			<div class="navbar-form navbar-right" ng-controller="ProfileController as profileController" >
				<span class="nav-action">					
					<a href="/DTA-Services/advert/new/" class="btn btn-warning" role="button"><spring:message code="page.header.postAdvert" /></a>
				</span>
				
				<div class="btn-group dropdown nav-action">
					<button class="btn btn-info name-button" ng-class="{'btn-danger' : profileController.balance < 0}">
						{{ profileController.balance | currency }} 
					</button>
					<a  href="<spring:url value="/profile" />" class="btn name-button" ><s:authentication property="principal.username"/> </a>
					<button class="btn name-button dropdown-toggle" data-toggle="dropdown" > <span class="caret"></span> </button>
					
					<ul class="dropdown-menu">
			            <li><a href="<spring:url value="/profile" />"><span class="glyphicon glyphicon-user"></span> <spring:message code="page.header.profile" /></a></li>
			            <li><a href="<spring:url value="/user/messages" />"><span class="glyphicon glyphicon-envelope"></span> <spring:message code="page.header.inbox" /></a></li>		            
		          	</ul>
		          
	          	</div>	
	          	<span >
					<a class="btn btn-danger" href="<spring:url value="/j_spring_security_logout" />" ><span class="glyphicon glyphicon-log-out"></span></a>
				</span>

			</div>
			
		</s:authorize>
		
		<s:authorize access="isAnonymous()">
			<form class="navbar-form navbar-right" action="<spring:url value="/j_spring_security_check" />" method="POST">
				<input class="form-control" name="j_username" type="text" placeholder="<spring:message code="page.header.login" />"/>
				<input class="form-control" name="j_password" type="password" placeholder="<spring:message code="page.header.password" />" />
				<button type="submit" class="btn btn-success"><spring:message code="page.header.signin" /></button>
				<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#registerModal" ><spring:message code="page.header.register" /></button>								
			</form>
		</s:authorize>
	</div>
</nav>

<div id="registerModal" class="modal fade">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <h1><spring:message code="page.header.modal.register.title" /></h1>
      </div>
      <f:form class="form-horizontal" modelAttribute="user" method="POST" action="${pageContext.request.contextPath }/register">
	      <div class="modal-body">		        
        	<div class="form-group">
        		<label class="control-label col-sm-3"><spring:message code="page.header.modal.register.login" /></label>
        		<div class="col-sm-6">
        			<f:input class="form-control" path="login" type="text" />
        		</div>
        		<div class="col-sm-3 control-label text-danger">
	        		<f:errors path="login" />
	       		</div>       				
        	</div>
        	
        	<div class="form-group">
        		<label class="control-label col-sm-3"><spring:message code="page.header.modal.register.password" /></label>
        		<div class="col-sm-6">
        			<f:input class="form-control" path="password" type="password" />
        		</div>  
        		<div class="col-sm-3 control-label text-danger">
	        		<f:errors path="password" />
	       		</div>      		       		
        	</div>
        	
        	<div class="form-group">
        		<label class="control-label col-sm-3"><spring:message code="page.header.modal.register.email" /></label>
        		<div class="col-sm-6">
        			<f:input class="form-control" path="email"  />
        		</div>
        		<div class="col-sm-3 control-label text-danger">
	        		<f:errors path="email" />
	       		</div>        		       		
        	</div>
        	
        	<div class="form-group">        		
        		<label class="col-sm-3 control-label" >
        			<spring:message code="page.header.modal.register.country" />
        		</label>
        		<div class="col-sm-2">
        			<f:select path="country" class="form-control"  >
        				<f:options items="${com.dta.services.model.Country.values}" itemLabel="name" />
        			</f:select>
        		</div> 
        		<label class="col-sm-2 control-label" >
        			<spring:message code="page.header.modal.register.department" />
        		</label>
        		<div class="col-sm-2">
        			<f:select path="department" class="form-control"     >
        				<f:options items="${com.dta.services.model.Department.values}" itemLabel="name" />
        			</f:select>
        		</div>      		
        	</div>
        	<div class="form-group">
        		<div class="col-sm-6 text-danger">
        			<f:errors path="country" />      		
        		</div> 
        		<div class="col-sm-6 text-danger">
        			<f:errors path="department" />
        		</div>
        	</div>
        	<c:if test="${errorMessage != null }">
	        	<div class="alert alert-danger">
	        		<spring:message code="page.header.modal.register.error.login" />
	        	</div>
        	</c:if>	       				       
	      </div>
	      <div class="modal-footer">
	        	<button type="submit" class="btn btn-success"><spring:message code="page.header.modal.register.submit" /></button>
	      </div>
      </f:form>
    </div>
  </div>
</div>
