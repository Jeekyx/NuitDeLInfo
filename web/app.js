(function(angular) {
    'use strict';

    angular.module('ReportersApp', ['ngRoute', 'MainController', 'SignupController', 'ProfilController', 'CharityController', 'CampagnsController'])
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
                .when('/Campagns', {
                    templateUrl: 'views/Campagns.html',
                    controller: 'CampagnsController'
                })
            $locationProvider.html5Mode({
                enabled: true,
                requireBase: false
            });
        });
})(window.angular);
