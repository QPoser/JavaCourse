<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 31.05.2017
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href = "${pageContext.servletContext.contextPath}/views/user/CreateUser.jsp">Add client</a>
    <table border = "1">
        <tr>
            <td>Login Email</td>
            <td>Deistvya</td>
        </tr>
        <c:forEach items ="${users}" var="user" varStatus="status">
            <td>${user.login} ${user.email}</td>
            <td>
                <a href ="${pageContext.servletContext.contextPath}/user/edit?id=${user.id}">Redact</a>
                <a href ="${pageContext.servletContext.contextPath}/user/delete?id=${user.id}">Delete</a>
            </td>
        </c:forEach>
    </table>

</body>
</html>
