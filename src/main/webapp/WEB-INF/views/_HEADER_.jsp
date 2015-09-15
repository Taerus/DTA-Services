<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<header>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"><spring:message code="page.header.title"></spring:message></a>
			<ul class="nav navbar-nav">
				<li><a href="/"><spring:message code="page.header.members"></spring:message></a></li>
				<li><a href="/"><spring:message code="page.header.adverts"></spring:message></a></li>
			</ul>
			<form class="navbar-form navbar-right">
				<input class="form-control" type="text" placeholder="<spring:message code="page.header.login"></spring:message>"/>
				<input class="form-control" type="password" placeholder="<spring:message code="page.header.password"></spring:message>" />
				<button type="submit" class="btn btn-success"><spring:message code="page.header.signin"></spring:message></button>
				<button class="btn btn-primary"><spring:message code="page.header.register"></spring:message></button>				
			</form>
		</div>
	</nav>
</header>