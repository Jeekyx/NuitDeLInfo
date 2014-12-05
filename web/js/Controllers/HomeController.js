/**
 * Created by Cocotouf on 04/12/2014.
 */

var app = angular.module("HomeController", ['ngRoute']);

app.controller("HomeController", ['$scope', function($scope) {
    $scope.name = "home";
}]);