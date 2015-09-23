<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="s"%>

<nav class="navbar navbar-default">
	<div class="container-fluid">
		<a class="navbar-brand" href="/DTA-Services"><spring:message code="page.header.title"></spring:message></a>
		
		<ul class="nav navbar-nav">
			<li><a href="/DTA-Services/users/"><spring:message code="page.header.users"></spring:message></a></li>
			<li><a href="/DTA-Services/adverts/"><spring:message code="page.header.adverts"></spring:message></a></li>
		</ul>
		
		<s:authorize access="hasRole('USER')">
			<a href="/DTA-Services/advert/new/" class="btn btn-warning" role="button"><spring:message code="page.header.postAdvert" /></a>
			<ul class="nav navbar-nav navbar-right">
			
				<li><a href="/DTA-Services/j_spring_security_logout"><spring:message code="page.header.logout" /> </a></li>
			</ul>
			<p class="navbar-text navbar-right"><spring:message code="page.header.signedin" /> <a href="#" class="navbar-link"><s:authentication property="principal.username" /></a></p>
			
		</s:authorize>
		
		
		
		<s:authorize access="isAnonymous()">
			<form class="navbar-form navbar-right" action="/DTA-Services/j_spring_security_check" method="POST">
			<input class="form-control" name="j_username" type="text" placeholder="<spring:message code="page.header.login"></spring:message>"/>
			<input class="form-control" name="j_password" type="password" placeholder="<spring:message code="page.header.password"></spring:message>" />
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
      <f:form class="form-horizontal" modelAttribute="user" method="POST" action="/DTA-Services/register">
	      <div class="modal-body">		        
        	<div class="form-group">
        		<label class="control-label col-sm-3"><spring:message code="page.header.modal.register.login"></spring:message></label>
        		<div class="col-sm-7">
        			<f:input class="form-control" path="login" type="text" />
        		</div>
        		<div class="col-sm-2 control-label text-danger">
        			<f:errors path="login" />
        		</div>	        		
        	</div>
        	<div class="form-group">
        		<label class="control-label col-sm-3"><spring:message code="page.header.modal.register.password"></spring:message></label>
        		<div class="col-sm-7">
        			<f:input class="form-control" path="password" type="password" />
        		</div>
        		<div class="col-sm-2 control-label text-danger">
        			<f:errors path="password" />
        		</div>	        		
        	</div>
        	<div class="form-group">
        		<label class="control-label col-sm-3"><spring:message code="page.header.modal.register.email" ></spring:message></label>
        		<div class="col-sm-7">
        			<f:input class="form-control" path="email" type="email" />
        		</div>
        		<div class="col-sm-2 control-label text-danger">
        			<f:errors path="email" />
        		</div>	        		
        	</div>
        	<div class="form-group">
        		<label class="col-sm-3 control-label" >
        			<spring:message code="page.header.modal.register.department" ></spring:message>
        		</label>
        		<div class="col-sm-3">
        			<f:input path="department" class="form-control"/>
        		</div>
        		<label class="col-sm-1 control-label" >
        			<spring:message code="page.header.modal.register.country" ></spring:message>
        		</label>
        		<div class="col-sm-3">
        			<f:input path="country" class="form-control"/>
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
