/**
 * Created by User on 21.07.2016.
 */
$(document).ready(function () {
    $("#btnOrderTaxi").toggle(function () {
        $("#taxiOrderDivId").fadeIn()
        return false;
    }, function () {
        $("#taxiOrderDivId").fadeOut()
        return false
    })
})