<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 01.06.2017
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>

<form action="${pageContext.servletContext.contextPath}/user/edit" method="POST">
    <input type="hidden" name="id" value="${user.id}">
    <table>
        <tr>
            <td align="right" >Login : </td>
            <td>
                <input type="text" name="login" value="${user.login}">
            </td>
        </tr>
        <tr>
            <td align="right" >Email : </td>
            <td>
                <input type="email" name="email" value="${user.email}">
            </td>
        </tr>
        <tr>
        <c:if test="${pet == null}">
            <span>Havent pet! </span><a href = "${pageContext.servletContext.contextPath}/user/createPet?id=${user.id}">Create!</a>
        </c:if>
            <c:if test="${pet != null}">
                <span>${pet.type()} ${pet.name} ${pet.age} ${pet.voice()}</span>
            </c:if>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Submit"/></td>
        </tr>
    </table>
</form>
</body>
</html>