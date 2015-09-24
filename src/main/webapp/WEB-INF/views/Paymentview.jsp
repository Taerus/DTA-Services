<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
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
	<div class="panel default-panel">
		<div class="panel-body">
			<p>
				<strong>Vous êtes sur le point d'envoyer un paiement à ${ userTo }
					:</strong>
			</p>
			<form class="form-horizontal" action="#" method="POST">
				<div class="form-group">
					<label class="control-label col-sm-3">Montant : </label>
					<div class="col-sm-3">
						<input class="form-control" name="credits" type="number" />
					</div>
				</div>
			</form>
		</div>
	</div>
	</main>
	<footer>
		<c:import url="_FOOTER_.jsp"></c:import>
	</footer>
	<script>
		console.log("${ userTo }")
	</script>
</body>
</html>