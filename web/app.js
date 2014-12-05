(function(angular) {
    'use strict';

    angular.module('ReportersApp', ['ngRoute', 'MainController', 'SignupController', 'ProfilController', 'CharityController'])
        .controller("MainController", function ($scope, $route, $routeParams, $location) {
            $scope.$route = $route;
            $scope.$location = $location;
            $scope.$routeParams = $routeParams;
        })
        .controller("SignupController", function ($scope, $routeParams) {
            $scope.name = "signup";
            $scope.params = $routeParams;
        })
        .config(function ($routeProvider, $locationProvider) {
            $routeProvider
                 .when('/Profil/:profilId', {
                 templateUrl: 'views/Signup.html',
                 controller: 'ProfilController'
                 })
                 .when('/Charity/:charityId', {
                 templateUrl: 'views/Signup.html',
                 controller: 'CharityController'
                 })
                .when('/Signup', {
                    templateUrl: 'views/Signup.html',
                    controller: 'SignupController'
                })
            $locationProvider.html5Mode({
                enabled: true,
                requireBase: false
            });
        });
})(window.angular);
