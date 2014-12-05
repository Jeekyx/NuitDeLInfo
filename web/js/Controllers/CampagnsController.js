/**
 * Created by Cocotouf on 04/12/2014.
 */
angular.module("CampagnsController", ['ngRoute', 'APIService'])
    .controller("CampagnsController", function ($scope, $route, $routeParams, $location, APIService) {
        $scope.APIService = new APIService();

        $scope.name = "campagns";
        $scope.campagns = {};

        $scope.APIService.getCampagns(function(error, data) {
            if (!error)
                $scope.campagns = data;
        });


    });