angular.module("dta-services")
    .controller("MessageListController", MessageListController);

function MessageListController(MessageService) {
    "use strict";
    var _this = this;

    MessageService.getSentMessages(51).then(function(result) {
        _this.sent = result.data;
        _this.messages = _this.sent;
    });

    _this.selected = {};

    _this.select = function(idx) {
        _this.selected = _this.messages[idx];
    };

}

