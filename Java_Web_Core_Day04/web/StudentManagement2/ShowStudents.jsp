<%@ page import="java.util.ArrayList" %>
<%@ page import="StudentManagement2.Student" %><%--
  Created by IntelliJ IDEA.
  User: willdufresne
  Date: 10/26/20
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ShowStudents</title>
</head>
<body>
<table border="1px" width="500px" align="center">
    <tr align="center">
        <td>姓名</td>
        <td>年龄</td>
        <td>分数</td>
    </tr>

    <%
        Object studentList = request.getAttribute("StudentList");
        ArrayList<Student> list = (ArrayList<Student>) studentList;
        for (Student student : list) {
    %>
    <tr align="center">
        <td><%out.write(student.getName());%></td>
        <td><%out.write(student.getAge());%></td>
        <td><%out.write(student.getScore());%></td>
    </tr>
    <%
        }
    %>
    <%
        out.write("<a href=\"/Java_Web_Core_Day04/StudentManagement2/HomePage.jsp\">返回首页</a>");
    %>

</table>

</body>
</html>
