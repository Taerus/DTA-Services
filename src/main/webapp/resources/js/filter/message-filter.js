angular.module("dta-services")
    .filter("msgDate", MessageDateFilter);

function MessageDateFilter($filter) {
    "use strict";

    var dateFilter = $filter('date');

    return function(dateToFormat) {
        var date = new Date(dateToFormat).toLocaleDateString();
        var now = new Date().toLocaleDateString();

        if(date == now) {
            return dateFilter(dateToFormat, "HH:mm");
        } else {
            return dateFilter(dateToFormat, "d/M/yyyy");
        }
    }
}