angular.module("dta-services", ['ui.bootstrap'])
    .config(providerConfig);

function providerConfig($locationProvider) {
    $locationProvider.html5Mode({
        enabled: true,
        requireBase: false
    });
}