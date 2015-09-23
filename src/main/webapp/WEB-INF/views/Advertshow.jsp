<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><spring:message code="page.home.title"></spring:message></title>
	<c:import url="_STYLESHEETS_.jsp"></c:import>
	<c:import url="_SCRIPT_.jsp"></c:import>
</head>
<body>
	<header>
		<c:import url="_HEADER_.jsp"></c:import>
	</header>
	<main class="container">
		<div class="row">
			<div class="panel panel-primary">
		  		<div class="panel-heading">
		    		<h3 class="panel-title"><strong>Annonce n°${ myAdvert.id } :</strong> ${ myAdvert.title } - postée le : ${ myAdvert.creation } </h3>
		  		</div>
		  		<div class="panel-body">
		    		<em>${ myAdvert.description }</em>
		  		</div>
		  		<ul class="list-group">
				    <li class="list-group-item"><strong>auteur : </strong></li>
				    <li class="list-group-item"><strong>catégorie concernée : </strong>${ myAdvert.category.name }</li>
				    <li class="list-group-item"><strong>crédit(s) : </strong>${ myAdvert.price }</li>
			  	</ul>
			</div>
			
			<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteAdvert">Suppression</button>
			<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#editAdvert">Edition</button>
			
			<div id="deleteAdvert" class="modal fade">
				<div class="modal-dialog">
			    	<div class="modal-content">
			    		<div class="modal-header">
			        		<h1>Supprimer l'annonce n°${ myAdvert.id }</h1>
			      		</div>
			      		<f:form class="form-horizontal" modelAttribute="advert" method="GET" action="/DTA-Services/advert/delete/${myAdvert.id}/">
							<div class="modal-footer">
					        	<button type="submit" class="btn btn-success">Oui</button>
					        	<button type="button" class="btn btn-danger" data-dismiss="modal">Non</button>
							</div>
						</f:form>
					</div>
				</div>
			</div>
			
			<div id="editAdvert" class="modal fade">
				<div class="modal-dialog">
			    	<div class="modal-content">
			    		<div class="modal-header">
			        		<h1>Edition de l'annonce n°${ myAdvert.id }</h1>
			      		</div>
			      		<f:form class="form-horizontal" modelAttribute="myAdvert" method="POST" action="/DTA-Services/advert/new/">
			      			<div class="modal-body">	
			      				<f:hidden path="id"/>	        
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
						    </div>
							<div class="modal-footer">
					        	<button type="submit" class="btn btn-success">Editer</button>
					        	<button type="button" class="btn btn-warning" data-dismiss="modal">Annuler</button>
							</div>
						</f:form>
					</div>
				</div>
			</div>
			
		</div>
	</main>
	<footer>
		<c:import url="_FOOTER_.jsp"></c:import>
	</footer>
</body>
</html>