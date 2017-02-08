/**
 * Created by MichaelMAC on 18.01.17.
 */
var makeTrainingApp = angular.module ("makeTrainingApp", []);

makeTrainingApp.controller("makeTrainingCtrl", function ($scope, $http){

    $scope.time = '00:00:00';

    /**
     * Adds exercise item to workout. Sends chosen exercise to spring controller and gets refreshed list from it.
     * @param exerciseId if of chosen exercise.
     */
    $scope.addExercise = function (exerciseId) {
        $http.post('/eGym/rest/exerciseItem/add/'+exerciseId, $scope.itemList).success(function (data) {
            $scope.itemList = data;
        });
    };

    /**
     * Method for saving workout. Send the data to spring controller.
     * @param clientId
     */
    $scope.saveWorkout = function (clientId) {
        var duration = $scope.calculateTime();
        console.log(duration);
        $http.post('/eGym/rest/exerciseItem/saveWorkout', $scope.itemList,  {params : {'clientId' : clientId, 'duration' : duration }}).
        success(function () {
            alert('Workout was added successful!')
        });
    };

    /**
     * Init method. Gets data from spring controller
     */
    $scope.init = function () {

        $http.get('/eGym/rest/exerciseItem/init').success(function (data) {
            $scope.itemList = data;
        });
    };


    /**
     * Method for calculating total time of workout in seconds.
     * @returns total time in seconds
     */
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

/**
 * Directive to forbid entering non-numeric characters
 */
makeTrainingApp.directive('numeric', function() {
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

/**
 * Converts seconds to HH:MM:SS string of time
 * @returns {string} of time
 */
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
