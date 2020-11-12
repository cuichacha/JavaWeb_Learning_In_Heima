<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: willdufresne
  Date: 11/12/20
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<String> list = new ArrayList();
    list.add("1");
    list.add("2");
    list.add("3");
    pageContext.setAttribute("list", list);
%>

<c:forEach items="${list}" var="i" varStatus="status">
    ${status.count} -- ${i} <br>
</c:forEach>
</body>
</html>
