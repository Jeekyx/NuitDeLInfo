(function(angular) {
    'use strict';

    angular.module('ReportersApp', ['ngRoute', 'MainController', 'SignupController', 'ProfilController', 'CharityController'])
        .config(function ($routeProvider, $locationProvider) {
            $routeProvider
                 .when('/Profil/:profilId', {
                 templateUrl: 'views/Profil.html',
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
                .when('/Home', {
                    templateUrl: 'views/Home.html',
                    controller: 'HomeController'
                })
            $locationProvider.html5Mode({
                enabled: true,
                requireBase: false
            });
        });
})(window.angular);
