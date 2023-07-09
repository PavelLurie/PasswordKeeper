<%--
  Created by IntelliJ IDEA.
  User: pavel
  Date: 19.06.2023
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LogIn</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
</head>

<body>
<form class="form" action="" method="post">
    <input class="input" type="text" placeholder="e-mail" id="login" name="login">

    <input class="input" type="password" placeholder="Пароль" id="password" name="password">

    <button class="btn" type="submit">Войти</button>
</form>
</body>
</html>

<%--<input class="input" type="password" placeholder="Пароль еще раз" id="passconf" name="passconf">--%>
<%--<input class="input" type="password" placeholder="Пароль еще раз">--%>
<%--<input class="input" type="email" placeholder="Ваш e-mail">--%>
<%--<input class="input" type="tel" placeholder="Ваш телефон" id="phonenumber" name="phonenumber">--%>