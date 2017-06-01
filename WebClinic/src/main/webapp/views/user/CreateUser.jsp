<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 22.05.2017
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create client</title>
</head>
<body>

    <form action="${pageContext.servletContext.contextPath}/user/create" method="post">

        <table>
            <tr>
                <td align="right">Login : </td>
                <td>
                    <input type = "text" name = "login">
                </td>
            </tr>
            <tr>
                <td align="right">Email : </td>
                <td>
                    <input type = "text" name = "email">
                </td>
            </tr>
            <tr>
                <td><input type="submit" align="center" value="Submit"></td>
            </tr>
        </table>
    </form>

</body>
</html>
