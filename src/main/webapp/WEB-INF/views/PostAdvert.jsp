<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><spring:message code="page.postAdvert.title" /></title>
	<c:import url="_STYLESHEETS_.jsp" />
	<c:import url="_SCRIPT_.jsp" />
</head>
<body>

<header>
	<c:import url="_HEADER_.jsp" />
    <div class="container">
        <h1><spring:message code="page.postAdvert.title" /></h1>
    </div>
</header>

<main class="container">
	<div class="well col-md-offset-2 col-md-8">
		<f:form action="/DTA-Services/advert/new" method="post" cssClass="form-horizontal" modelAttribute="advert">
            <div class="form-group">
                <label for="title" class="control-label col-md-2"><spring:message code="page.postAdvert.form.title" /></label>
                <div class="col-md-10"><f:input path="title" id="title" cssClass="form-control" /></div>
            </div>
            <div class="form-group">
                <label for="description" class="control-label col-md-2"><spring:message code="page.postAdvert.form.description" /></label>
                <div class="col-md-10"><f:textarea path="description" id="description" cssClass="form-control" rows="8" /></div>
            </div>
            <div class="form-group">
                <label for="price" class="control-label col-md-2"><spring:message code="page.postAdvert.form.price" /></label>
                <div class="col-md-10"><f:input path="price" id="price" type="number" cssClass="form-control" /></div>
            </div>
            <div class="form-group">
                <div class="col-md-offset-2 col-md-10">
                    <button type="submit" class="btn btn-success"><spring:message code="page.postAdvert.form.submit" /></button>
                </div>
            </div>
		</f:form>
	</div>
</main>

<footer>
	<c:import url="_FOOTER_.jsp" />
</footer>

</body>
</html>