<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 07.06.2016
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>SaTax</title>
    <meta charset="UTF-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js" type="text/javascript"></script>
    <script src="JavaScript/loginPassword_Validation.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="mainPageView.css">
    <div id="toEnterSys">
        <form action="/login" method="post">
            <strong style="color: white">Логін:</strong>
            <br>
            <input type="text" maxlength="25" size="25" name="loginForEnter" id="loginIdForEnter" placeholder="Логін">
            <div style="color: white; float: right;" size="30" id="loginValidation"></div>
            <br>
            <strong style="color: white">Пароль:</strong>
            <br>
            <input type="password" maxlength="15" size="25" id="passwordIdForEnter" name="password"
                   placeholder="Пароль">
            <div style="color: white; float: right" size="30" id="passvalidation"></div>
            <br>
            <br>
            <input id="enterToWorkStaceBTN" type="submit" value="Війти" disabled/>
            <button style="border-radius: 15px;border-color: yellow; background-color: transparent"><a
                    style="color: white"
                    href="#reestrationForm" name="reestrationBTN_1">Реєстрація</a>
            </button>
        </form>
    </div>

    <%--Применяем AJAX--%>
    <%--Вызов сервлета--%>
    <br>
</head>
<body id="back_ground">
<div id="ordersMultimedia">
    <div id="videos">
        <iframe id="video_kiev" width="100%" height="465"
                src="http://www.youtube-nocookie.com/embed/jN_Fpi2zLLw?iv_load_policy=3" frameborder="0"
                allowtransparency="10%"></iframe>
    </div>

    <div id="orderForm">
        <form action="/orderReestration" method="post" id="formOrderReestrationID">
            <div align="center" style="padding-top:30px">
                <strong style="color: black">Замовлення таксі:</strong>
                <br>
                <br>
                <strong style="color: black">Місце подачі авто</strong>
                <br>
                <input type="text" ; maxlength="50" ; size="20" ; name="streetFrom" placeholder="вул.">
                <input type="text" ; maxlength="6" ; size="5" ; name="houseFrom" placeholder="буд.">
                <input type="text" maxlength="3" size="5" ; name="blockFrom" placeholder="під'їзд">
                <br>
                <br>
                <input type="text" maxlength="50" size="40" name="notes" placeholder="Коментар (за бажанням)">
                <br>
                <br>
                <br>
                <strong style="color: black">Пункт призначення</strong>
                <br>
                <input type="text" maxlength="50" size="20" name="streetTo" placeholder="вул.">
                <input type="text" maxlength="6" size="5" name="houseTo" placeholder="буд.">
                <input type="text" maxlength="3" size="5" ; name="blockTo" placeholder="під'їзд">
                <br>
                <br>
                <input type="text" maxlength="11" size="25" name="phonenumber" placeholder="Номер телефону">
                <input type="text" maxlength="25" size="25" name="fioOrder" placeholder="Ім'я">
                <br>
                <br>
                <input type="submit" value="Замовити таксі" style="color: #6c6761"/>
            </div>
        </form>
    </div>
</div>

<br>

<div id="links" align="center">
    <a name="http://kiev.vgorode.ua/" class="href"> <img
            src="http://mi6.ua/img/price/vgorode/250_150logo_1416566232vg.jpg"
            alt="vgorode"
            height="75" width="210"></a>
    <a name="//www.gismeteo.ua/" class="href"> <img src="http://s2.gismeteo.ua/static/images/logo253x100.jpg"
                                                    alt="gismeteo"
                                                    height="75" width="210"></a>
    <a name="http://www.youtube.com/v/jN_Fpi2zLLw?iv_load_policy=3" class="href"> <img
            src="http://www.youtube.com/yt/brand/media/image/YouTube-logo-full_color.png"
            alt="youtube"
            height="75" width="210"></a>
    <a name="http://booking.uz.gov.ua/" class="href"> <img
            src="http://i.piccy.info/i7/e3faac9e632d3e2484e021ca5b4df825/1-5-1271/9653960/logo.png" alt="uz"
            height="75" width="210"></a>
    <a name="http://kbp.aero/passengers/schedule/" class="href"> <img
            src="http://myavia.com.ua/wp-content/uploads/2012/12/%D0%9C%D0%B5%D0%B6%D0%B4%D1%83%D0%BD%D0%B0%D1%80%D0%BE%D0%B4%D0%BD%D1%8B%D0%B9-%D0%B0%D1%8D%D1%80%D0%BE%D0%BF%D0%BE%D1%80%D1%82-%D0%91%D0%BE%D1%80%D0%B8%D1%81%D0%BF%D0%BE%D0%BB%D1%8C-%D0%BB%D0%BE%D0%B3%D0%BE.jpg"
            alt="youtube"
            height="75" width="210"></a>
</div>
<br>
<div id="middleFutterDivId">
    <div id="reestrationContacts">
        <div id="reestrationForm">
            <br>
            <form action="/reestration" method="post" style="width: 100%">
                <div align="center"><strong style="color: white;">Реєстрація:</strong></div>
                <div align="center" ; style="padding-top:20px">
                    <input type="text" maxlength="50" size="55" name="fioReestration" placeholder="Введіть ПІБ">
                    <br>
                    <br>
                    <input type="text" maxlength="25" size="25" name="loginReestration"
                           placeholder="Введіть новий логін">
                    <input type="password" maxlength="15" size="25" name="passwordReestration"
                           placeholder="Введіть новий пароль">
                    <br>
                    <br>
                    <input type="text" maxlength="13" size="25" name="phonenumberReestration"
                           placeholder="Номер телефону">
                    <input type="text" maxlength="50" size="25" name="emailReestration" placeholder="Email">
                    <br>
                    <br>
                    <input type="submit" value="Зареєструватися"/>
                </div>
            </form>
        </div>


        <div name="contacts" id="contactsDivId">
            <div align="center">
                <strong id="ourContaxtsId">Наші контакти</strong></div>
            <br>
            <div id="topPhons">
                <div name="phoneLifeName" id="phoneLifeId">
                    <strong>Life</strong>
                    <br>
                    <strong>+380633530621</strong>
                </div>
                <div name="phoneKievStarName" id="phoneKievStarId">
                    <strong>Kiev Star</strong>
                    <br>
                    <strong>+380672420912</strong>
                </div>
            </div>
            <br>
            <div id="futerContacts">
                <div name="phoneVodafonName" id="phoneVodafonId">
                    <strong style="align-self: center">Vodafon</strong>
                    <br>
                    <strong>+380503530621</strong>
                </div>
                <div name="standartPhoneName" id="standartPhoneId">
                    <strong>Міський телефон</strong>
                    <br>
                    <strong>0445455506</strong>
                </div>
            </div>
        </div>
    </div>
    <br>

    <div id="footer">
        <div id="copyRight" align="center">
            <script language="JavaScript">
                document.write('<FONT COLOR="white">');
                document.write('&copy;');
                document.write(' 2016 - ');
                document.write(new Date().getFullYear());
                document.write(' Salva&Co - All Rights Reserved.');
                document.write('</FONT>');
            </script>
        </div>
    </div>
</div>
</body>
</html>
