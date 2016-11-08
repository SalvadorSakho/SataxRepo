<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10.07.2016
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Work Sapce SaTax</title>
    <meta charset="UTF-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js" type="text/javascript"></script>
    <script src="JavaScript/userValidation.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="userWorkPageView.css">
</head>
<body id="workBackGround">
<div id="useValidationId">
    <h2><span class="entypo-login"></span> Login</h2>
    <button id="validationBtn"><span class="entypo-lock"></span></button>
    <%--  <span class="entypo-user inputUserIcon"></span>--%>
    <input type="text" class="user" placeholder="введи свій логін тварино" id="userLoginId" name="userLoginName"/>
    <%--<span class="entypo-key inputPassIcon"></span>--%>
    <input type="password" class="pass" placeholder="введи свій пароль тварино" id="userPasswordId"
           name="userPasswordName"/>
</div>
<div id="orderTableIdDiv" name="orderTableName" align="center"></div>
</body>
</html>
