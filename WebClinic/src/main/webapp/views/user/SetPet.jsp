<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 01.06.2017
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ci" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <ci:if test="${pet != null}">
        <title>Edit pet</title>
    </ci:if>
    <ci:if test="${pet == null}">
        <title>Create pet</title>
    </ci:if>
</head>
<body>

<form action="${pageContext.servletContext.contextPath}/user/createPet" method="POST">
    <input type="hidden" name="id" value="${user.id}">
    <input type="hidden" name="addPet" value="${addPet}">
    <input type="hidden" name="editPet" value="${editPet}">
    <table>
        <tr>
        <select name="select" size = "1">
            <option selected value = "cat">Cat</option>
            <option value = "dog">Dog</option>
        </select>
        </tr>

        <tr>
        <td>Name : </td>
        <td>
            <ci:choose>
                <ci:when test="${pet == null}">
                    <input type="text" name="name" value="">
                </ci:when>
                <ci:when test="${pet != null}">
                    <input type="text" name="name" value="${pet.name}">
                </ci:when>
            </ci:choose>
        </td>
    </tr>
        <tr>
            <td>Age : </td>
            <td>
                <input type="number" name="age">
            </td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Sumbit"></td>
        </tr>
    </table>
</form>

</body>
</html>
