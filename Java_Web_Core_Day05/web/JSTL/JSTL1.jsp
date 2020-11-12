<%--
  Created by IntelliJ IDEA.
  User: willdufresne
  Date: 11/12/20
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL1</title>
</head>
<body>
${pageContext.setAttribute("score", "E")}

<%--<c:if test="${score == 'A'}">--%>
<%--    好--%>
<%--</c:if>--%>

<c:choose>
    <c:when test="${score == 'A'}">好</c:when>
    <c:when test="${score == 'B'}">不好</c:when>
    <c:when test="${score == 'C'}">不好</c:when>
    <c:when test="${score == 'D'}">不好</c:when>
    <c:otherwise>啦啦啦</c:otherwise>
</c:choose>
</body>
</html>
