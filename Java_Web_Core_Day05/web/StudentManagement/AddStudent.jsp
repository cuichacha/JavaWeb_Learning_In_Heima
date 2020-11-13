<%--
  Created by IntelliJ IDEA.
  User: willdufresne
  Date: 11/12/20
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddStudent</title>
</head>
<body>
<form action="/Java_Web_Core_Day05/AddStudent" method="post">
    <label for="name">姓名：</label>
    <input type="text" id="name" name="name">
    <label for="age">年龄：</label>
    <input type="text" id="age" name="age">
    <label for="score">分数：</label>
    <input type="text" id="score" name="score">
    <input type="submit" value="提交">
</form>
</body>
</html>
