/**
 * Created by Cocotouf on 04/12/2014.
 */

var app = angular.module("CharityController", ['ngRoute']);

app.controller("CharityController", ['$scope', '$routeParams', function($scope, $routeParams) {
    $scope.name = "charity";
    $scope.params = $routeParams;
}]);