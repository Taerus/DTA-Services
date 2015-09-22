<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title><spring:message code="page.listPrivateMessage.title" /></title>
  <c:import url="_STYLESHEETS_.jsp" />
  <c:import url="_SCRIPT_.jsp" />
  <script src="/DTA-Services/js/services/message-service.js"></script>
  <script src="/DTA-Services/js/controller/message-controller.js"></script>
</head>
<body ng-app="dta-services">

<header>
  <c:import url="_HEADER_.jsp" />
  <div class="container">
    <h1><spring:message code="page.listPrivateMessage.title" /></h1>
  </div>
</header>

<main class="container">
  <div ng-controller="MessageListController as ctrl" class="row">
    <div class="well col-md-6">
      <ul>
        <li ng-repeat="message in ctrl.messages track by $index">
          <span class="btn-link" ng-click="ctrl.select($index)"> {{ message.title }}</span>
        </li>
      </ul>
    </div>
    <div class="well col-md-6">
      <p>{{ ctrl.selected.content }}</p>
    </div>
  </div>
</main>

<footer>
  <c:import url="_FOOTER_.jsp" />
</footer>

</body>
</html>