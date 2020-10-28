<%--
  Created by IntelliJ IDEA.
  User: willdufresne
  Date: 10/27/20
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="/Java_Web_Core_Day04/StudentManagement2/Login" method="post">
    <label for="username">姓名：</label>
    <input type="text" id="username" name="username" required>
    <br>
    <label for="password">密码：</label>
    <input type="password" id="password" name="password" required>
    <br>
    <input type="submit">
</form>
</body>
</html>
