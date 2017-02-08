/**
 * Created by MichaelMAC on 08.02.17.
 */

/**
 * Specifies the datepicker and timepicker attributes
 */
$(document).ready(function () {

    $('#timepicker').timepicker({
        'minTime': '10:00',
        'maxTime': '22:00',
        'showDuration': true,
        'timeFormat': 'H:i',
        'show2400': true,
        'step': 60
    });

    $("#datepicker").datepicker({
        dateFormat: "dd-mm-yy",
        minDate: 0,
        onSelect: function(dateText) {
            var scope = angular.element(document.querySelector('[ng-controller="clientTrainingTimeCtrl"]')).scope();
            scope.updateData(dateText);
        }
    });
});
