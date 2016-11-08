/**
 * Created by User on 22.07.2016.
 */
var streetValidationFrom = 0;
var housValidationFrom = 0;
var blockValidationFrom = 0;
var streetValidationTo = 0;
var housValidationTo = 0;
var blockValidationTo = 0;

$(document).ready(function () {

    $("#streetFrom").focusout(function () {
        if ($(this).val() != '') {
            var pattern = /[=]|[+]|[a-z]|[A-Z]|[_]|[0-9]/;
            if (pattern.test($(this).val())) {
                $(this).css({'border': '1px solid #ff0000'});
                $(this).html("введена не вірна адреса");
                streetValidationFrom = 0;
                $("#setOrder").prop("disabled", true);
            } else {
                $(this).css({'border': '1px solid #569b44'});
                streetValidationFrom = 1;
                if (streetValidationFrom == 1 && housValidationFrom == 1 && streetValidationTo == 1 && housValidationTo == 1 && blockValidationFrom == 1 && blockValidationTo == 1) {
                    $("#setOrder").removeAttr("disabled");
                }
            }
        } else {
            $(this).css({'border': '1px solid #ff0000'});
            $(this).html("введена не вірна адреса");
            streetValidationFrom = 0;
            $("#setOrder").prop("disabled", true);
        }
    });

    $("#houseFrom").focusout(function () {
        if ($(this).val() != '') {
            var pattern = /[=]|[+]|[a-z]|[A-Z]|[_]/;
            if (pattern.test($(this).val())) {
                housValidationFrom = 0;
                $(this).css({'border': '1px solid #ff0000'});
                $("#setOrder").prop("disabled", true);
            } else {
                $(this).css({'border': '1px solid #569b44'});
                housValidationFrom = 1;
                if (streetValidationFrom == 1 && housValidationFrom == 1 && streetValidationTo == 1 && housValidationTo == 1 && blockValidationFrom == 1 && blockValidationTo == 1) {
                    $("#setOrder").removeAttr("disabled");
                }
            }
        } else {
            $(this).css({'border': '1px solid #ff0000'});
            housValidationFrom = 0;
            $("#setOrder").prop("disabled", true);
        }
    });

    $("#blockFrom").focusout(function () {
        if ($(this).val() != '') {
            var pattern = /[=]|[+]|[a-z]|[A-Z]|[_]|[А-ЯЁ]|[а-яё]/;
            if (pattern.test($(this).val())) {
                $(this).css({'border': '1px solid #ff0000'});
                blockValidationFrom = 0;
                $("#setOrder").prop("disabled", true);
            } else {
                $(this).css('border', '1px solid #569b44');
                blockValidationFrom = 1;
                if (streetValidationFrom == 1 && housValidationFrom == 1 && streetValidationTo == 1 && housValidationTo == 1 && blockValidationFrom == 1 && blockValidationTo == 1) {
                    $("#setOrder").removeAttr("disabled");
                }
            }
        } else {
            $(this).css({'border': '1px solid #ff0000'});
            blockValidationFrom = 0;
            $("#setOrder").prop("disabled", true);
        }
    });

    $("#streetTo").focusout(function () {
        if ($(this).val() != '') {
            var pattern = /[=]|[+]|[a-z]|[A-Z]|[_]|[0-9]/;
            if (pattern.test($(this).val())) {
                $(this).css({'border': '1px solid #ff0000'});
                streetValidationTo = 0;
                $("#setOrder").prop("disabled", true);
            } else {
                $(this).css({'border': '1px solid #569b44'});
                streetValidationTo = 1;
                if (streetValidationFrom == 1 && housValidationFrom == 1 && streetValidationTo == 1 && housValidationTo == 1 && blockValidationFrom == 1 && blockValidationTo == 1) {
                    $("#setOrder").removeAttr("disabled");
                }
            }
        } else {
            $(this).css({'border': '1px solid #ff0000'});
            $('#answer').html("введена не вірна адреса");
            streetValidationTo = 0;
            $("#setOrder").prop("disabled", true);
        }
    });

    $("#houseTo").focusout(function () {
        if ($(this).val() != '') {
            var pattern = /[=]|[+]|[a-z]|[A-Z]|[_]/;
            if (pattern.test($(this).val())) {
                housValidationTo = 0;
                $(this).css({'border': '1px solid #ff0000'});
                $("#setOrder").prop("disabled", true);
            } else {
                $(this).css('border', '1px solid #569b44');
                housValidationTo = 1;
                if (streetValidationFrom == 1 && housValidationFrom == 1 && streetValidationTo == 1 && housValidationTo == 1 && blockValidationFrom == 1 && blockValidationTo == 1) {
                    $("#setOrder").removeAttr("disabled");
                }
            }
        } else {
            $(this).css({'border': '1px solid #ff0000'});
            housValidationTo = 0;
            $("#setOrder").prop("disabled", true);
        }
    });

    $("#blockTo").focusout(function () {
        if ($(this).val() != '') {
            var pattern = /[=]|[+]|[a-z]|[A-Z]|[_]|[А-ЯЁ]|[а-яё]/;
            if (pattern.test($(this).val())) {
                $(this).css({'border': '1px solid #ff0000'});
                blockValidationTo = 0;
                $("#setOrder").prop("disabled", true);
            } else {
                $(this).css('border', '1px solid #569b44');
                blockValidationTo = 1;
                if (streetValidationFrom == 1 && housValidationFrom == 1 && streetValidationTo == 1 && housValidationTo == 1 && blockValidationFrom == 1 && blockValidationTo == 1) {
                    $("#setOrder").removeAttr("disabled");
                }
            }
        } else {
            $(this).css({'border': '1px solid #ff0000'});
            blockValidationTo = 0;
            $("#setOrder").prop("disabled", true);
        }
    });
})
