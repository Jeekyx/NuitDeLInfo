/**
 * Created by Cocotouf on 04/12/2014.
 */
angular.module("MainController", ['ngRoute'])
    .controller("MainController", function($scope, $routeParams) {
        $scope.data = $routeParams;
    })
    .controller("SignupController", function($scope, $routeParams) {
        $scope.name = "signup";
    })

    ;