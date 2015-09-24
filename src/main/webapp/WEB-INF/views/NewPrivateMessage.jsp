<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><spring:message code="page.sendPrivateMessage.title" /></title>
	<c:import url="_STYLESHEETS_.jsp" />
	<c:import url="_SCRIPT_.jsp" />
</head>
<body>

<header>
	<c:import url="_HEADER_.jsp" />
    <div class="container">
        <h1><spring:message code="page.sendPrivateMessage.title" /></h1>
    </div>
</header>

<main class="container">
	<div class="well col-md-offset-2 col-md-8">
		<f:form action="/DTA-Services/message/send" method="post" cssClass="form-horizontal" modelAttribute="message">
            <c:forEach items="${message.targets}" varStatus="vs">
                <f:hidden path="targets[${vs.index}]" />
            </c:forEach>
            <div class="form-group">
                <label for="subject" class="control-label col-md-2"><spring:message code="page.sendPrivateMessage.form.subject" /></label>
                <div class="col-md-10"><f:input path="subject" id="subject" cssClass="form-control" /></div>
            </div>
            <div class="form-group">
                <label for="content" class="control-label col-md-2"><spring:message code="page.sendPrivateMessage.form.content" /></label>
                <div class="col-md-10"><f:textarea path="content" id="content" cssClass="form-control" rows="8" /></div>
            </div>
            <div class="form-group">
                <div class="col-md-offset-2 col-md-10">
                    <button type="submit" class="btn btn-success"><spring:message code="page.sendPrivateMessage.form.submit" /></button>
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