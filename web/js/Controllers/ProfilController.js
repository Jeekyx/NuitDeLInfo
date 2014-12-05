/**
 * Created by Cocotouf on 04/12/2014.
 */

var app = angular.module("ProfilController", []);

app.controller("ProfilController", ['$scope', '$routeParams', function($scope, $routeParams) {
    $scope.data = "profil";
    $scope.params = $routeParams;
    console.log("here");

}]);