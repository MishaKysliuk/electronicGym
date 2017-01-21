/**
 * Created by MichaelMAC on 18.01.17.
 */

var addCategoryApp = angular.module ("addCategoryApp", []);

addCategoryApp.controller("addCategoryCtrl", function ($scope, $http){

    $scope.initCategories = function () {
        $http.get('/eGym/rest/category/init').success(function (data) {
            $scope.categoryList = data;
        });

    };
    $scope.addCategory = function () {
        $http.get('/eGym/rest/category/add', {params: {'categoryName': $scope.categoryName}}).success(function (data) {
            $scope.categoryList = data;
            alert("Category successfully added!")
        });
        $scope.categoryName = '';
    };
});


