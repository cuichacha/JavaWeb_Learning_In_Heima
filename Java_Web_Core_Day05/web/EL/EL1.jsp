<%--
  Created by IntelliJ IDEA.
  User: willdufresne
  Date: 11/12/20
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Expression Language1</title>
</head>
<body>
<% request.setAttribute("username", "zhangsan"); %>
Java: <% out.println(request.getAttribute("username")); %> <br>
JSP: <%= request.getAttribute("username") %> <br>
EL: ${username}
</body>
</html>
