/**
 * Created by MichaelMAC on 18.01.17.
 */
var clientTrainingTimeApp = angular.module ("clientTrainingTimeApp", []);
clientTrainingTimeApp.controller("clientTrainingTimeCtrl", function ($scope, $http) {

    $scope.disabledTime = [];


    /**
     * init method for disabling time by today date. Gets disabled time array from spring controller
     */
    $scope.init = function () {
        var date = dateToString(new Date());

        $http.get('/eGym/rest/clientTrainingTime/disabledTime', date).success(function (result) {
            $scope.disabledTime = createArray(result);
            $(document).ready(function () {
                $('#timepicker').timepicker('option', 'disableTimeRanges', $scope.disabledTime);
            });
        });

    };

    /**
     * Updates disabled time by sending chosen date to spring controller and retrieving new disabled time array
     * @param date chosen date
     */
    $scope.updateData = function (date) {
        $http.get('/eGym/rest/clientTrainingTime/disabledTime', date).success(function (result) {
            $scope.disabledTime = createArray(result);
            $(function () {
                $('#timepicker').timepicker('option', 'disableTimeRanges', $scope.disabledTime);
            });
        });
    }

});


/**
 * Creates two-dimensional array from one-dimensional in order to disable time into timepicker.
 * The row of result array consists of ['from time', 'to time'].
 * @param temp one-dimensional array
 * @returns two-dimensional array
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

/**
 * Converts date to string
 * @param date date to convert
 * @returns {string}
 */
var dateToString = function (date) {
    var mm = date.getMonth() + 1; // getMonth() is zero-based
    var dd = date.getDate();

    return [(dd>9 ? '' : '0') + dd,
        (mm>9 ? '' : '0') + mm,
        date.getFullYear()
    ].join('-');
};