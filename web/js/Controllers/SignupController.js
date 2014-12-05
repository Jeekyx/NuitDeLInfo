/**
 * Created by Cocotouf on 04/12/2014.
 */

var app = angular.module("SignupController", ['ngRoute']);

app.controller("SignupController", ['$scope', '$routeParams', function($scope, $routeParams) {
    $scope.name = "signup";
    $scope.params = $routeParams;
}]);