angular.module("dta-services")
    .controller("MessageListController", MessageListController);

function MessageListController(MessageService, $scope, $location) {
    "use strict";
    var _this = this;

    _this.load = function(userId) {
        var sentReq = MessageService.getSentMessages(userId);
        var receivedReq = MessageService.getReceivedMessages(userId);

        if($location.hash() == "sent") {
            sentReq.then(function(result) {
                sent(result);
                _this.onSentSelected();
            });
            receivedReq.then(received);
        } else {
            receivedReq.then(function(result) {
                received(result);
                _this.onReceivedSelected();
            });
            sentReq.then(sent);
        }

        function received(result) {
            _this.received = sortMessage(result.data);
        }

        function sent(result) {
            _this.sent = sortMessage(result.data);
        }
    };

    _this.onReceivedSelected = function() {
        _this.select(0, 'r');
        $location.hash('received');
        _this.tab = 'r';
    };

    _this.onSentSelected = function() {
        _this.select(0, 's');
        $location.hash('sent');
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

    _this.setTab = function(t) {
        _this.tab = t;
        _this.select(0, t);
        _this.receivedTab = t == 'r';
        _this.sentTab = t == 's';
    };

    $scope.$watch(function () {
        return $location.hash();
    }, function (value) {
        if(value == 'received') {
            _this.setTab('r');
        } else if(value == 'sent') {
            _this.setTab('s');
        }
    });

    function sortMessage(messages) {
        if(messages) {
            messages = messages.sort(function(a, b) {
                return b.creationDate - a.creationDate;
            })
        }

        return messages;
    }

}

