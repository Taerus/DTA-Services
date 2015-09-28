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
    <script src="<spring:url value="/js/filter/message-filter.js" />"></script>
    <script src="<spring:url value="/js/service/message-service.js" />"></script>
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
            <tab heading="Messages reçus" select="ctrl.onReceivedSelected()" active="ctrl.receivedTab">
                <div class="list-group">
                    <a class="list-group-item" href="#" class="btn-link"
                       ng-class="{'active':receivedMsg.message.id == ctrl.selected.message.id}"
                       ng-click="ctrl.select($index)"
                       ng-repeat="receivedMsg in ctrl.received track by $index">
                            <span style="display: inline-block; width: 8em">
                                {{ receivedMsg.message.author.login }}</span>
                            <span style="border-left:1px solid #ddd; padding-left:1em;">
                                {{ receivedMsg.message.title }}</span>
                            <span class="pull-right">
                                {{ receivedMsg.message.creationDate | msgDate }}</span>
                    </a>
                </div>
            </tab>
            <tab heading="Messages envoyés" select="ctrl.onSentSelected()" active="ctrl.sentTab">
                <div class="list-group">
                    <a class="list-group-item" href="#" class="btn-link"
                       ng-class="{'active':sentMsg.message.id == ctrl.selected.message.id}"
                       ng-click="ctrl.select($index)"
                       ng-repeat="sentMsg in ctrl.sent track by $index">
                            <span style="display: inline-block; width: 8em">
                                {{ sentMsg.message.targets[0].login }}</span>
                            <span style="border-left:1px solid #ddd; padding-left:1em;">
                                {{ sentMsg.message.title }}</span>
                            <span class="pull-right">
                                {{ sentMsg.message.creationDate | msgDate }}</span>
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
                <button class="btn btn-danger" ng-click="ctrl.delete()">
                    <spring:message code="page.listPrivateMessage.control.delete" />
                </button>
            </div>
            <div class="panel panel-primary">
                <div class="panel-heading">{{ ctrl.selected.message.title }}
                    <span class="pull-right">{{ ctrl.selected.message.creationDate | msgDate }}</span>
                </div>
                <div class="panel-body">
                    <p>
                        <strong>{{ ctrl.selected.message.author.login }}</strong><br>
                        pour : {{ ctrl.selected.message.targets[0].login }}
                        <hr>
                        <span style="white-space: pre-wrap">{{ ctrl.selected.message.content }}</span>
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