angular.module("dta-services")
    .controller("MessageListController", MessageListController);

function MessageListController(MessageService) {
    "use strict";
    var _this = this;

    _this.load = function(userId) {
        MessageService.getReceivedMessages(userId).then(function(result) {
            _this.received = sortMessage(result.data);
            _this.select(0, 'r');
        });

        MessageService.getSentMessages(userId).then(function(result) {
            _this.sent = sortMessage(result.data);
        });
    };

    _this.onReceivedSelected = function() {
        _this.select(0, 'r');
        _this.tab = 'r';
    };

    _this.onSentSelected = function() {
        _this.select(0, 's');
        _this.tab = 's';
    };

    _this.select = function(idx, tab) {
        if(tab == 'r') {
            _this.messages = _this.received;
        } else if(tab == 's') {
            _this.messages = _this.sent;
        }

        if(_this.messages) {
            _this.selected = _this.messages[idx];
        }
    };

    function sortMessage(messages) {
        if(messages) {
            messages = messages.sort(function(a, b) {
                return b.creationDate - a.creationDate;
            })
        }

        return messages;
    }

}

