/**
 * Created by MichaelMAC on 08.02.17.
 */

/**
 * Make the content of div block with id referenced from 'href' attribute of class 'nav-toggle' to be shown or hide
 */
$(document).ready(function () {
    $('.nav-toggle').click(function () {
        //get collapse content selector
        var collapse_content_selector = $(this).attr('href');

        //make the collapse content to be shown or hide
        var toggle_switch = $(this);
        $(collapse_content_selector).toggle(function () {
            if ($(this).css('display') == 'none') {
                //change the button label to be 'Add new category'
                toggle_switch.html('Add new category');
            } else {
                //change the button label to be 'Hide'
                toggle_switch.html('Hide');
            }
        });
    });

});
