/**
 * Created by MichaelMAC on 08.02.17.
 */

/**
 * Specify the data table attributes
 */
$(document).ready(function(){
    $('#data-table').DataTable({
        "lengthMenu": [[2,3,5,10,-1], [2,3,5,10, "All"]],
    });
});
