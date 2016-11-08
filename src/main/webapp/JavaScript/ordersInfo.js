/**
 * Created by User on 10.07.2016.
 */
$(document).ready(function () {
    $.ajax({
        url: "/usersOrders",
        type: "post",
        data: {
            userIdLogin: $('#inputIdLogin').val()
        },
        success: function (responceText) {

            $("#tabIDLastOrders").append($("<tr>").append(
                $("<th>").append("Адреса подачі авто")
                , $("<th>").append("Адреса пункту призначення")
                , $("<th>").append("Дата замовлення")
                , $("<th>").append("Марка авто")
                , $("<th>").append("Тариф")));

            var arr = responceText.split(";")

            for (var i = 0; i < arr.length - 1; i++) {
                var row = $("<tr>")
                var rowVar = arr[i];
                var rowSplit = rowVar.split(",")

                for (var v = 0; v < rowSplit.length; v++) {
                    var cellInfo = rowSplit[v]
                    row.append($("<td>").html(cellInfo))
                }
                $("#tabIDLastOrders").append(row)
            }
        }
    });
});