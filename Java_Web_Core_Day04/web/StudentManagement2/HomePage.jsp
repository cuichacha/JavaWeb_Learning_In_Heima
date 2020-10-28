<%--
  Created by IntelliJ IDEA.
  User: willdufresne
  Date: 10/26/20
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomePage</title>
</head>
<body>
<%
    Cookie[] cookies = request.getCookies();
    Cookie temp = null;
    if (cookies == null) {
        response.getWriter().write("<a href=\"/Java_Web_Core_Day04/StudentManagement2/Login.jsp\">请先登录</a>");
    } else {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("isLogin") && cookie.getValue().equals("true")) {
                temp = cookie;
            }
        }
        if (temp != null) {
            response.getWriter().write("<a href=\"/Java_Web_Core_Day04/StudentManagement2/AddStudents.html\">添加学生</a>");
            response.getWriter().write("<a href=\"/Java_Web_Core_Day04/StudentManagement2/ShowStudents.jsp\">查看学生</a>");
        } else {
            response.getWriter().write("<a href=\"/Java_Web_Core_Day04/StudentManagement2/Login.jsp\">请先登录</a>");
        }
    }
%>
</body>
</html>
