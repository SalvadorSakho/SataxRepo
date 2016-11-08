/**
 * Created by User on 07.07.2016.
 */
var enterToWorkSpaceLogin = 0;
var enterToWorkSpacePass = 0;

$(document).ready(function () {
    var access = new Image();
    var accessDenien = new Image();
    access.src = "tick.png";
    accessDenien.src = "error.png";
    access.width = 20;
    access.height = 20;
    accessDenien.width = 20;
    accessDenien.height = 20;

    $("#loginIdForEnter").focusout(function () {
        if ($(this).val() != '') {
            var pattern = /[=]|[+]/;
            if (pattern.test($(this).val())) {
                $(this).css({'border': '2px solid #ff0000'});
                enterToWorkSpaceLogin = 0
                $('#loginValidation').html(accessDenien);
                $("#enterToWorkStaceBTN").prop("disabled", true);
            } else {
                $(this).css({'border': '2px solid #569b44'});
                $('#loginValidation').html(access);
                enterToWorkSpaceLogin = 1
                if (enterToWorkSpaceLogin == 1 && enterToWorkSpacePass == 1) {
                    $("#enterToWorkStaceBTN").removeAttr("disabled");
                }
            }
        } else {
            $(this).css({'border': '2px solid #ff0000'});
            enterToWorkSpaceLogin = 0
            $('#loginValidation').html(accessDenien);
            $("#enterToWorkStaceBTN").prop("disabled", true);
        }
    });
});

$(document).ready(function () {
    var access = new Image();
    var accessDenien = new Image();
    access.src = "tick.png";
    accessDenien.src = "error.png";
    access.width = 20;
    access.height = 20;
    accessDenien.width = 20;
    accessDenien.height = 20;

    $("#passwordIdForEnter").focusout(function () {
        if ($(this).val() != "") {
            var pattern = /[=]|[+]/;
            if (pattern.test($(this).val())) {
                $(this).css({'border': '2px solid #ff0000'});
                enterToWorkSpacePass = 0
                $('#passvalidation').html(accessDenien);
                $("#enterToWorkStaceBTN").prop("disabled", true);
            } else {
                $(this).css({'border': '2px solid #569b44'});
                $('#passvalidation').html(access);
                enterToWorkSpacePass = 1
                if (enterToWorkSpaceLogin == 1 && enterToWorkSpacePass == 1) {
                    $("#enterToWorkStaceBTN").removeAttr("disabled");
                }
            }
        } else {
            $(this).css({'border': '2px solid #ff0000'});
            enterToWorkSpacePass = 0
            $('#passvalidation').html(accessDenien);
            $("#enterToWorkStaceBTN").prop("disabled", true);
        }
    });
});


$(document).ready(function () {
    $(".href").click(function () {
        $("#video_kiev").attr("src", $(this).attr("name"));
    })
});