/**
 * Created by Cocotouf on 05/12/2014.
 */
var app = angular.module("APIService", []);

app.factory('APIService', function APIService($http) {
    var apiService = function() {
        var path = "http://gm-dev.fr:3333/";
        var header = {'Content-Type' : 'application/json', 'Accept' : 'application/json'};

        this.getCampagns = function(callback) {
            var pathFunction = path + "campaigns";
            $http.get(pathFunction, {
                headers:header
                })
                .success(function (data) {
                    callback(null, data);
                })
                .error(function(e) {
                    callback(e);
                })
        }
    };


    return apiService;
})