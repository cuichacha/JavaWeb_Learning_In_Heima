<%@ page import="bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: willdufresne
  Date: 11/12/20
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Expression Language2</title>
</head>
<body>

<% pageContext.setAttribute("num", 10); %>
${num} <br>

<%
    Student student = new Student("zhangsan", "23", "0");
    pageContext.setAttribute("student", student);
%>
${student} <br>
${student.name} <br>
${student.age} <br>
${student.score} <br>

<%
    int[] arr = {1, 2, 3,};
    pageContext.setAttribute("arr", arr);
%>
${arr} <br>
${arr[0]} <br>
${arr[2]} <br>

<%
    List<Integer> numbers = new ArrayList<>();
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
    pageContext.setAttribute("numbers", numbers);
%>
${numbers} <br>
${numbers[2]}

<%
    Map<String, Integer> map = new HashMap<>();
    map.put("hm1", 1);
    map.put("hm1.1", 1);
    pageContext.setAttribute("map", map);
%>
${map} <br>
${map.hm1} <br>
${map["hm1.1"]}
</body>
</html>
