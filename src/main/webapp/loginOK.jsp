<%--
  Created by IntelliJ IDEA.
  User: pavel
  Date: 06.07.2023
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LoginOK</title>

    <style>
        <%@include file="/WEB_INF/styleLoginOk.css"%>
    </style>
</head>
<body>

<form class="form" action="" method="post">

    <div id="wrapper">
        <input id="name" placeholder="Название" type="text" name="name">
        <input id="site" placeholder="Сайт" type="text" name="site">
        <input id="login" placeholder="Имя пользователя" type="text" name="login">
        <input id="pass" placeholder="Пароль" type="text" name="pass">
    </div>

    <input checked="" id="add" name="action" type="radio" value="new">
    <label for="add">Создать пароль</label>
    <input id="signup" name="action" type="radio" value="add">
    <label for="signup">Сохранить</label>


    <button type="submit">
    <span>
      Reset password
      <br>
      Создать пароль
      <br>
      Сохранить
    </span>
    </button>
</form>
</body>
</html>
