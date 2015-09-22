angular.module("dta-services")
    .factory("MessageService", MessageService);

function MessageService($http) {
    "use strict";

    var API = "/DTA-Services/API";

    var service = {};

    service.getReceivedMessages = function(userId) {
        return $http.get(API + "/user/" + userId + "/message/received");
    };

    service.getSentMessages = function(userId) {
        return $http.get(API + "/user/" + userId + "/message/sent");
    };

    return service;

}
