<%@ page import="bean.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: willdufresne
  Date: 11/12/20
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL3</title>
</head>
<body>
<%
    String str = "";
    Student student = null;
    List list = new ArrayList<>();
    pageContext.setAttribute("str", str);
    pageContext.setAttribute("student", student);
    pageContext.setAttribute("list", list);
%>
${empty str} <br>
${empty student} <br>
${empty list} <br>

<%
    pageContext.setAttribute("gender", "female");
%>
<input type="radio" name="gender" value="male" checked="${gender eq "male" ? "checked" : ""}">男
<input type="radio" name="gender" value="female" checked="${gender eq "male" ? "checked" : ""}">女
</body>
</html>
