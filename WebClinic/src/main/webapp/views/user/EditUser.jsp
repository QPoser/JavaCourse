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
    <input type="hidden" name="email" value="${user.email}">
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
                <input type="password" name="password" value="${user.password}">
            </td>
        </tr>
        <tr>
        <c:if test="${pets.size() == 0}">
            <span>Havent pets! </span><a href = "${pageContext.servletContext.contextPath}/user/createPet?id=${user.id}&addPet=1">Create!</a>
        </c:if>
            <c:if test="${pets != null}">
                <c:forEach items ="${pets}" var="pet" varStatus="status">
                <span>${pet.type()} ${pet.name} ${pet.age} ${pet.voice()}</span>
                <br>
                <a href = "${pageContext.servletContext.contextPath}/user/editPet?id=${user.id}&editPet=1&petName=${pet.name}">
                    <input type = "button" align = "center" value="Edit">
                </a>
                <br>
                <a href = "${pageContext.servletContext.contextPath}/user/deletePet?id=${user.id}&petName=${pet.name}">
                    <input type = "button" align = "center" value="Delete">
                </a> <br>
                </c:forEach>
                <a href = "${pageContext.servletContext.contextPath}/user/createPet?id=${user.id}&addPet=1">
                    <input type = "button" align = "center" value="Add pet">
                </a> <br>
            </c:if>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Submit"/></td>
        </tr>
    </table>
</form>
</body>
</html>
