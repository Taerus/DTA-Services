<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<a class="navbar-brand" href="/DTA-Services"><spring:message code="page.header.title"></spring:message></a>
		
		<ul class="nav navbar-nav">
			<li><a href="/DTA-Services/users/"><spring:message code="page.header.users"></spring:message></a></li>
			<li><a href="/DTA-Services/adverts/"><spring:message code="page.header.adverts"></spring:message></a></li>
		</ul>
		
		<form class="navbar-form navbar-right">
			<a href="/DTA-Services/advert/new/" class="btn btn-warning" role="button"><spring:message code="page.header.postAdvert" /></a>
		
			<input class="form-control" type="text" placeholder="<spring:message code="page.header.login"></spring:message>"/>
			<input class="form-control" type="password" placeholder="<spring:message code="page.header.password"></spring:message>" />
			<button type="submit" class="btn btn-success"><spring:message code="page.header.signin" /></button>
			<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#registerModal" ><spring:message code="page.header.register" /></button>				
		</form>
	</div>
</nav>

<div id="registerModal" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1><spring:message code="page.header.modal.register.title" /></h1>
      </div>
      <f:form class="form-horizontal" modelAttribute="user" method="POST" action="/DTA-Services/register">
	      <div class="modal-body">		        
        	<div class="form-group">
        		<label class="control-label col-sm-3"><spring:message code="page.header.modal.register.login" /></label>
        		<div class="col-sm-9">
        			<f:input class="form-control" path="login" type="text" />
        		</div>	        		
        	</div>
        	<div class="form-group">
        		<label class="control-label col-sm-3"><spring:message code="page.header.modal.register.password" /></label>
        		<div class="col-sm-9">
        			<f:input class="form-control" path="password" type="password" />
        		</div>	        		
        	</div>
        	<div class="form-group">
        		<label class="control-label col-sm-3"><spring:message code="page.header.modal.register.email"  /></label>
        		<div class="col-sm-9">
        			<f:input class="form-control" path="email" type="email" />
        		</div>	        		
        	</div>	        					       
	      </div>
	      <div class="modal-footer">
	        	<button type="submit" class="btn btn-success"><spring:message code="page.header.modal.register.submit" /></button>
	      </div>
      </f:form>
    </div>
  </div>
</div>