/**
 * Created by Cocotouf on 04/12/2014.
 */
angular.module("CampaignsController", ['ngRoute', 'APIService'])
    .controller("CampaignsController", function ($scope, $route, $routeParams, $location, APIService) {
        $scope.APIService = new APIService();

        $scope.campaigns = {};

        $scope.APIService.getCampagns(function(error, data) {
            if (!error)
                $scope.campaigns = data;
        });


    });