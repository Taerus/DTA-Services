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
    <script src="/DTA-Services/js/service/message-service.js"></script>
    <script src="/DTA-Services/js/filter/message-filter.js"></script>
    <script src="/DTA-Services/js/controller/message-controller.js"></script>
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
        <div class="col-md-6">
            <ul class="nav nav-tabs" role="tablist">
                <li role="presentation" class="active">
                    <a href="#received" aria-controls="received" role="tab" data-toggle="tab" ng-click="ctrl.select(0, 'r')">
                        Messages reçus
                    </a>
                </li>
                <li role="presentation">
                    <a href="#sent" aria-controls="sent" role="tab" data-toggle="tab" ng-click="ctrl.select(0, 's')">
                        Messages envoyés
                    </a>
                </li>
            </ul>

            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active" id="received">
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
                </div>
                <div role="tabpanel" class="tab-pane" id="sent">
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
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="panel panel-primary" ng-if="ctrl.selected.id">
                <div class="panel-heading">{{ ctrl.selected.title }} <span class="pull-right">{{ ctrl.selected.creationDate | msgDate }}</span></div>
                <div class="panel-body">
                    <p>
                        <strong>{{ ctrl.selected.author.login }}</strong><br>
                        pour : {{ ctrl.selected.targets[0].login }}
                        <hr>
                        {{ ctrl.selected.content }}
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