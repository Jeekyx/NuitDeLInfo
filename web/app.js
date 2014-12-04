(function(angular) {
    'use strict';

    angular.module('ReportersApp', ['ngRoute'])
        .controller("MainController", function ($scope, $route, $routeParams, $location) {
            $scope.$route = $route;
            $scope.$location = $location;
            $scope.$routeParams = $routeParams;
        })
        .controller("SignupController", function ($scope) {
            $scope.name = "signup";
        })
        .config(function ($routeProvider, $locationProvider) {
            $routeProvider
                /*.when('/Profil/:profilId', {
                 templateUrl: 'views/Profil.html',
                 controller: 'ProfilController'
                 })
                 .when('/charity/:charityId', {
                 templateUrl: 'views/Charity.html',
                 controller: 'CharityController'
                 })*/
                .when('/Signup', {
                    templateUrl: 'Signup.html',
                    controller: 'SignupController'
                })
            $locationProvider.html5Mode({
                enabled: true,
                requireBase: false
            });
        });
})(window.angular);
