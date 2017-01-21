/**
 * Created by MichaelMAC on 18.01.17.
 */
var clientTrainingTimeApp = angular.module ("clientTrainingTimeApp", []);
clientTrainingTimeApp.controller("clientTrainingTimeCtrl", function ($scope, $http) {

    $scope.disabledTime = [];


    $scope.init = function () {
        var date = dateToString(new Date());

        $http.post('/eGym/rest/clientTrainingTime/disabledTime', date).success(function (result) {
            $scope.disabledTime = createArray(result);
            $(document).ready(function () {
                $('#timepicker').timepicker('option', 'disableTimeRanges', $scope.disabledTime);
            });
        });

    };

    $scope.updateData = function (date) {
        $http.post('/eGym/rest/clientTrainingTime/disabledTime', date).success(function (result) {
            $scope.disabledTime = createArray(result);
            $(function () {
                $('#timepicker').timepicker('option', 'disableTimeRanges', $scope.disabledTime);
            });
        });
    }

});

/**
 * PS}DA{PSDASKDOPSKADPOKASPODKAPOSDK
 * @param temp
 * @returns {Array}
 */

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