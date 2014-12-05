/**
 * Created by Cocotouf on 04/12/2014.
 */
angular.module("MainController", ['ngRoute'])
    .controller("MainController", function ($scope, $route, $routeParams, $location) {
        $scope.$route = $route;
        $scope.$location = $location;
        $scope.$routeParams = $routeParams;

        window.data = {};


    });