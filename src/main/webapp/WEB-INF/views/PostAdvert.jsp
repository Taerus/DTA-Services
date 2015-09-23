<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<f:form class="form-horizontal" modelAttribute="advert" method="POST" action="/DTA-Services/advert/new">
            <div class="form-group">
		        <label class="control-label col-md-2"><spring:message code="page.postAdvert.post.title" /></label>
	        	<div class="col-md-10">
	        		<f:input class="form-control" path="title" type="text" />
	        	</div>
		    </div>
		    <div class="form-group">
		    	<label class="control-label col-md-2">Catégorie associée : </label>
		    	<div class="col-md-10">
		    		<f:select class="form-control" path="category.id">
		    			<c:forEach items="${ categories }" var="ctg">
		    				<f:option value="${ ctg.id }">${ ctg.name } / ${ ctg.id }</f:option>
		    			</c:forEach>
		    		</f:select>
	        	</div>
		    </div>
		    <div class="form-group">
		        <label for="description" class="control-label col-md-2"><spring:message code="page.postAdvert.post.description" /></label>
		        <div class="col-md-10">
		        	<f:textarea class="form-control" path="description" rows="8" />
		        </div>
		    </div>    
		    <div class="form-group">
		        <label for="price" class="control-label col-md-2"><spring:message code="page.postAdvert.post.price" /></label>
		        <div class="col-md-10">
		        	<f:input class="form-control" path="price" type="number" />
		        </div>
		    </div>
            <div class="form-group">
                <div class="col-md-offset-2 col-md-10">
                    <button type="submit" class="btn btn-success"><spring:message code="page.postAdvert.post.submit"></spring:message></button>
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