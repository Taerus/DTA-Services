<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><spring:message code="page.listPrivateMessage.title"/></title>
    <c:import url="_STYLESHEETS_.jsp"/>
    <c:import url="_SCRIPT_.jsp"/>
    <script src="<spring:url value="/js/service/message-service.js" />"></script>
    <script src="<spring:url value="/js/filter/message-filter.js" />"></script>
    <script src="<spring:url value="/js/controller/message-controller.js" />"></script>
</head>
<body ng-app="dta-services">

<header>
    <c:import url="_HEADER_.jsp"/>
    <div class="container">
        <h1><spring:message code="page.listPrivateMessage.title"/></h1>
    </div>
</header>

<main class="container">
    <div ng-controller="MessageListController as ctrl" ng-init="ctrl.load(${userId})" class="row">

        <tabset  class="col-md-6">
            <tab heading="Messages reçus" select="ctrl.onReceivedSelected()">
                <div class="list-group">
                    <a class="list-group-item" href="#" class="btn-link"
                       ng-class="{'active':message.id == ctrl.selected.id}"
                       ng-click="ctrl.select($index)"
                       ng-repeat="message in ctrl.received track by $index">
                            <span style="display: inline-block; width: 8em">
                                {{ message.author.login }}</span>
                            <span style="border-left:1px solid #ddd; padding-left:1em;">
                                {{ message.title }}</span>
                            <span class="pull-right">
                                {{ message.creationDate | msgDate }}</span>
                    </a>
                </div>
            </tab>
            <tab heading="Messages envoyés" select="ctrl.onSentSelected()">
                <div class="list-group">
                    <a class="list-group-item" href="#" class="btn-link"
                       ng-class="{'active':message.id == ctrl.selected.id}"
                       ng-click="ctrl.select($index)"
                       ng-repeat="message in ctrl.sent track by $index">
                            <span style="display: inline-block; width: 8em">
                                {{ message.targets[0].login }}</span>
                            <span style="border-left:1px solid #ddd; padding-left:1em;">
                                {{ message.title }}</span>
                            <span class="pull-right">
                                {{ message.creationDate | msgDate }}</span>
                    </a>
                </div>
            </tab>
        </tabset>

        <div class="col-md-6" ng-if="ctrl.selected.id">
            <div class="form-group">
                <button ng-if="ctrl.tab == 's'" class="btn btn-primary" disabled >
                    <spring:message code="page.listPrivateMessage.control.respond" />
                </button>
                <a ng-if="ctrl.tab != 's'" class="btn btn-primary"
                   href="<spring:url value="/message/new" />?to={{ ctrl.selected.author.id }}&re={{ ctrl.selected.id }}">
                    <spring:message code="page.listPrivateMessage.control.respond" />
                </a>
                <button class="btn btn-danger">
                    <spring:message code="page.listPrivateMessage.control.delete" />
                </button>
            </div>
            <div class="panel panel-primary">
                <div class="panel-heading">{{ ctrl.selected.title }}
                    <span class="pull-right">{{ ctrl.selected.creationDate | msgDate }}</span>
                </div>
                <div class="panel-body">
                    <p>
                        <strong>{{ ctrl.selected.author.login }}</strong><br>
                        pour : {{ ctrl.selected.targets[0].login }}
                        <hr>
                        <span style="white-space: pre-wrap">{{ ctrl.selected.content }}</span>
                    </p>
                </div>
            </div>
        </div>

    </div>
</main>

<footer>
    <c:import url="_FOOTER_.jsp"/>
</footer>

</body>
</html>