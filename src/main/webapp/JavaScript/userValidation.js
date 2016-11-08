/**
 * Created by User on 01.09.2016.
 */

var carId;
var carIDCell;
$(document).ready(function () {
    $("#validationBtn").click(function () {
        $.ajax({
            url: "/workerValidation",
            type: "post",
            data: {
                userLoginId: $('#userLoginId').val(), userPasswordId: $('#userPasswordId').val()
            }, success: function (responceText) {
                var answer = /exist/;

                if (answer.test(responceText)) {
                    $("#useValidationId").hide();


                    $.ajax({
                        url: "/ordersTableForStuff",
                        type: "post",
                        data: {}, success: function (responceText) {
                            alert("Працюй як слід тварино: " + $('#userLoginId').val())
                            $("#orderTableIdDiv").append($(document.createElement('table')).attr("id", "orderTableId").append($("<tr>").append(
                                $("<th>").append("ID замовлення")
                                , $("<th>").append("Адреса подачі авто")
                                , $("<th>").append("Адреса пункту призначення")
                                , $("<th>").append("ПІБ")
                                , $("<th>").append("Коментар")
                                , $("<th>").append("Дата замовлення")
                                , $("<th>").append("Авто")
                                , $("<th>").append("Тариф")
                                , $("<th>").append("Підтвердження")
                                , $("<th>").append("Редагування")
                            )))

                            var arr = responceText.split(";")
                            var z = 0;
                            for (var i = 0; i < arr.length - 1; i++) {
                                var row = $("<tr>")
                                var rowVar = arr[i];
                                var rowSplit = rowVar.split(",")

                                for (var v = 0; v < rowSplit.length + 2; v++) {
                                    var cellInfo = rowSplit[v]

                                    if (v == 0) {
                                        row.append($("<td>").attr("id", "orderId" + cellInfo).html(cellInfo))
                                    } else if (v == 6) {
                                        row.append($("<td class='autoClass'>").prop('contenteditable', true).html(cellInfo))
                                    } else if (v == 8) {
                                        var input = $('<div> <input class="acceptBtn" type="button" value="підтвердити" /> <div>');
                                        row.append($("<td>").html(input))
                                        z = z + 1
                                    } else if (v == 9) {
                                        var input = $('<div> <input class="refuceBtn" type="button" value="редагувати"/> <div>');
                                        row.append($("<td>").html(input))
                                        z = z + 1
                                    }

                                    else {
                                        row.append($("<td>").html(cellInfo))
                                    }
                                }
                                $("#orderTableId").append(row)
                            }
                        }
                    })
                }
            }
        });
    })
})
/*======================================== Доработать логику !!!!!!!!! (проставление ИД Такси) ========================================*/
$(document).on("focusout", '.autoClass', function () {


    carId = $(this).text();
    carIDCell = event.target
    $(carIDCell).prop('contenteditable', false)
    $(this).removeAttr('contenteditable')

})

$(document).on('click', '.acceptBtn', function () {
    alert(carId)
    $.ajax({
        url: "/setTaxiWorkers",
        type: "post",
        data: {
            carId: carId
        }, success: function (responceText) {

        }
    })
})

$(document).on('click', '.refuceBtn', function () {
    alert(carId)
    $(carIDCell).prop('contenteditable', true)
    /*    $.ajax({
     url:  "/",
     type: "post",
     data: {
     userIdLogin: $(carId)
     }, success: function (responceText) {
     }
     })*/
})

/*===================================== добавление элементов дизайна =====================================*/
$(".user").focusin(function () {
    $(".inputUserIcon").css("color", "#e74c3c");
}).focusout(function () {
    $(".inputUserIcon").css("color", "white");
});

$(".pass").focusin(function () {
    $(".inputPassIcon").css("color", "#e74c3c");
}).focusout(function () {
    $(".inputPassIcon").css("color", "white");
});

