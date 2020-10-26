<%--
  Created by IntelliJ IDEA.
  User: willdufresne
  Date: 10/26/20
  Time: 09:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomePage</title>
</head>
<body>
<%
    Cookie cookie = new Cookie("name", "value");
    cookie.setMaxAge(60);
    response.addCookie(cookie);
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie newCookie : cookies) {
            if (newCookie.getName().equals(cookie.getName()) && newCookie.getValue().equals(cookie.getValue())) {
                request.getRequestDispatcher("/AddStudents.html").forward(request, response);
            }
        }
        request.getRequestDispatcher("/Login.html").forward(request, response);
    } else {
        request.getRequestDispatcher("/Login.html").forward(request, response);
    }
%>
</body>
</html>
