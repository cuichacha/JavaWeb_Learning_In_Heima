<%--
  Created by IntelliJ IDEA.
  User: willdufresne
  Date: 10/25/20
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%
    Cookie cookie = new Cookie("name", "value");
    cookie.setMaxAge(300);
    response.addCookie(cookie);
    Cookie[] cookies = request.getCookies();
    for (Cookie newCookie : cookies) {
        if (newCookie.getName().equals(cookie.getName()) && newCookie.getValue().equals(cookie.getValue())) {
            request.getRequestDispatcher("/AddStudents.html").forward(request, response);
        }
    }
    request.getRequestDispatcher("/Login.html").forward(request, response);
%>
</body>
</html>
