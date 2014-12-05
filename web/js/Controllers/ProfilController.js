/**
 * Created by Cocotouf on 04/12/2014.
 */

var app = angular.module("ProfilController", ['ngRoute']);

app.controller("ProfilController", ['$scope', '$routeParams', function($scope, $routeParams) {
    $scope.name = "profil";
    $scope.params = $routeParams;
    $scope.data = window.data;
}]);