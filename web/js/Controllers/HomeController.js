/**
 * Created by Cocotouf on 04/12/2014.
 */

var app = angular.module("HomeController", ['ngRoute']);

app.controller("HomeController", ['$scope', '$routeParams', function($scope, $routeParams) {
    $scope.name = "home";
    $scope.params = $routeParams;
    $scope.data = window.data;
}]);