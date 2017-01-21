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

var makeTrainingApp = angular.module ("makeTrainingApp", []);

makeTrainingApp.controller("makeTrainingCtrl", function ($scope, $http){

    $scope.time = '00:00:00';

    $scope.addExercise = function (exerciseId, clientId) {
        $http.post('/eGym/rest/exerciseItem/add/'+exerciseId, $scope.itemList, {params: {'clientId' : clientId}}).success(function (data) {
            $scope.itemList = data;
        });
    };

    $scope.saveWorkout = function (clientId) {
        var duration = $scope.calculateTime();
        console.log(duration);
        $http.post('/eGym/rest/exerciseItem/saveWorkout', $scope.itemList,  {params : {'clientId' : clientId, 'duration' : duration }}).
        success(function () {
            alert('Workout was added successful!')
        });
    };
    $scope.init = function () {

        $http.get('/eGym/rest/exerciseItem/init').success(function (data) {
            $scope.itemList = data;
        });
    };


    $scope.calculateTime = function () {
        var totalSeconds = 0;
        for (var i=0; i<$scope.itemList.length; i++) {
            totalSeconds += $scope.itemList[i].exercise.avgSecondsForRep * $scope.itemList[i].reps * $scope.itemList[i].sets;
            totalSeconds += $scope.itemList[i].exercise.avgSecondsBetweenSets * $scope.itemList[i].sets;
        }
        $scope.time = totalSeconds.toString().toHHMMSS();
        return totalSeconds;
    }
});

makeTrainingApp.directive('productionQty', function() {
    return {
        require: 'ngModel',
        link: function (scope, element, attr, makeTrainingCtrl) {
            function fromUser(text) {
                var transformedInput = text.replace(/[^0-9]/g, '');
                if(transformedInput !== text) {
                    makeTrainingCtrl.$setViewValue(transformedInput);
                    makeTrainingCtrl.$render();
                }
                return transformedInput;  // or return Number(transformedInput)
            }
            makeTrainingCtrl.$parsers.push(fromUser);
        }
    };
});

String.prototype.toHHMMSS = function () {
    var sec_num = parseInt(this, 10); // don't forget the second param
    var hours   = Math.floor(sec_num / 3600);
    var minutes = Math.floor((sec_num - (hours * 3600)) / 60);
    var seconds = sec_num - (hours * 3600) - (minutes * 60);

    if (hours   < 10) {hours   = "0"+hours;}
    if (minutes < 10) {minutes = "0"+minutes;}
    if (seconds < 10) {seconds = "0"+seconds;}
    return hours+':'+minutes+':'+seconds;
};

var clientTrainingTimeApp = angular.module ("clientTrainingTimeApp", []);
clientTrainingTimeApp.controller("clientTrainingTimeCtrl", function ($scope, $http, DisabledTime) {

    $scope.disabledTime = [];


    $scope.init = function () {
        var date = dateToString(new Date());
        var timePromise = DisabledTime.getTime(date);
        timePromise.then(function(result) {
            $scope.disabledTime = createArray(result);
            $(function () {
                $('#timepicker').timepicker('option', 'disableTimeRanges', $scope.disabledTime);
            });
        });

    };

    $scope.updateData = function (date) {
        var timePromise = DisabledTime.getTime(date);
        timePromise.then(function(result) {
            $scope.disabledTime = createArray(result);
            $(function () {
                $('#timepicker').timepicker('option', 'disableTimeRanges', $scope.disabledTime);
            });
        });
    }



});

clientTrainingTimeApp.factory('DisabledTime', function($http) {
    return { getTime:  function getTime(dateText) {
        return $http.post('/eGym/rest/clientTrainingTime/disabledTime', dateText)
            .then(function (result) {
                return result.data;
            });
    }}
});

var createArray = function (temp) {
    var result = [];
    var indexOfResultArray = 0;
    for (var i=0; i < temp.length; indexOfResultArray++) {
        result[indexOfResultArray] = [];
        for(var j = 0; j < 2; j++, i++){
            result[indexOfResultArray][j] = temp[i];
        }
    }
    return result;
};

var dateToString = function (date) {
    var mm = date.getMonth() + 1; // getMonth() is zero-based
    var dd = date.getDate();

    return [(dd>9 ? '' : '0') + dd,
        (mm>9 ? '' : '0') + mm,
        date.getFullYear()
    ].join('-');
};



