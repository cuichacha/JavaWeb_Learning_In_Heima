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
    Cookie temp = null;
    cookie.setMaxAge(60);
    response.addCookie(cookie);
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie newCookie : cookies) {
            if (newCookie.getName().equals(cookie.getName()) && newCookie.getValue().equals(cookie.getValue())) {
                temp = newCookie;
            }
        }
        if (temp != null) {
            response.getWriter().write("<a href=\"/Java_Web_Core_Day04/StudentManagement1/AddStudents.html\">添加学生</a>");
            response.getWriter().write("<a href=\"/Java_Web_Core_Day04/StudentManagement1/ShowStudents.jsp\">查看学生</a>");
        } else {
            response.getWriter().write("<a href=\"/Java_Web_Core_Day04/StudentManagement1/Login.html\">请先登录</a>");
        }
    } else {
        response.getWriter().write("<a href=\"/Java_Web_Core_Day04/StudentManagement1/Login.html\">请先登录</a>");
    }

%>
</body>
</html>
