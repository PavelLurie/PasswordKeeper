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
    <%--<link href="${pageContext.request.contextPath}/WEB_INF/style.css" rel="stylesheet" type="text/css">--%>
    <style>
        <%@include file="/WEB_INF/style.css"%>
    </style>
</head>

<body>
<form class="form" action="" method="post">

    <input checked="" id="signin" name="signin" type="radio" value="signin">
    <label for="signin">Sign in</label>
    <input id="signup" name="signup" type="radio" value="signup">
    <label for="signup">Sign up</label>
    <input id="reset" name="reset" type="radio" value="reset">
    <label for="reset">Reset</label>
    <div id="wrapper">
        <div id="arrow"></div>
        <input id="email" placeholder="Email" type="text" name="login">
        <input id="pass" placeholder="Password" type="password" name="password">
        <input id="repass" placeholder="Repeat password" type="password" name="repass">
    </div>
    <button type="submit">
    <span>
      Reset password
      <br>
      Sign in
      <br>
      Sign up
    </span>
    </button>
</form>
<div id="hint">Click on the tabs</div>

<script type="text/javascript">

</script>

</body>

<%--<body>
<form class="form" action="" method="post">
    <input checked="" id="signin" name="action" type="radio" value="signin">
    <label for="signin">Sign in</label>
    <input id="signup" name="action" type="radio" value="signup">
    <label for="signup">Sign up</label>
    <input class="input" type="text" placeholder="e-mail" id="login" name="login">
    <input class="input" type="password" placeholder="Пароль" id="password" name="password">


    <button class="btn" type="submit">Войти</button>
</form>
</body>--%>
</html>

<%--<input class="input" type="password" placeholder="Пароль еще раз" id="passconf" name="passconf">--%>
<%--<input class="input" type="password" placeholder="Пароль еще раз">--%>
<%--<input class="input" type="email" placeholder="Ваш e-mail">--%>
<%--<input class="input" type="tel" placeholder="Ваш телефон" id="phonenumber" name="phonenumber">--%>