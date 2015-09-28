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

    service.deleteReceivedMessage = function(id) {
        $http.delete(API + "/message/received/" + id);
    };

    service.deleteSentMessage = function(id) {
        $http.delete(API + "/message/sent/" + id);
    };

    return service;

}
