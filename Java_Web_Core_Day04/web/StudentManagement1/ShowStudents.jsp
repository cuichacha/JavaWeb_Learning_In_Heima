<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.FileReader" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.io.InputStreamReader" %><%--
  Created by IntelliJ IDEA.
  User: willdufresne
  Date: 10/26/20
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ShowStudents</title>
</head>
<body>
<%
    ServletContext servletContext = getServletConfig().getServletContext();
    InputStream resourceAsStream = servletContext.getResourceAsStream("/StuInfo.txt");
    String realPath = servletContext.getRealPath("/StuInfo.txt");
//    BufferedReader bufferedReader = new BufferedReader(new FileReader(realPath));
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
    String str = null;
    while ((str = bufferedReader.readLine()) != null) {
        out.write(str);
        out.write("<br>");
    }
    bufferedReader.close();
    out.write("<br>");
    response.getWriter().write("<a href=\"/Java_Web_Core_Day04/StudentManagement1/HomePage.jsp\">回到首页</a> <br>");
    out.write("<br>");
%>
</body>
</html>
